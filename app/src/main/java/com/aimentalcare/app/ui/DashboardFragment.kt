package com.aimentalcare.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.fragment.app.Fragment
import com.aimentalcare.app.R
import com.aimentalcare.app.data.MentalCareDatabase
import com.aimentalcare.app.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ctx = context?.applicationContext ?: return
        val db = MentalCareDatabase.getDatabase(ctx)

        // Observe latest check-in for real-time dashboard updates
        db.checkInDao().getLatestCheckIn().observe(viewLifecycleOwner) { checkIn ->
            val b = _binding ?: return@observe
            if (checkIn != null) {
                b.txtStressGauge.text = checkIn.stressLevel
                b.progressStressGauge.progress = checkIn.stressScore
                b.txtStressPercent.text = getString(R.string.stress_percent_format, checkIn.stressScore)

                val badgeColor = when (checkIn.stressLevel) {
                    "LOW" -> "#10B981"
                    "MODERATE" -> "#F59E0B"
                    "HIGH" -> "#EF4444"
                    else -> "#991B1B"
                }
                b.txtStressBadge.text = checkIn.stressLevel
                b.txtStressBadge.setTextColor(badgeColor.toColorInt())

                // Dynamic Alert Title & Message
                if (checkIn.stressScore >= 75 || checkIn.isCrisis) {
                    b.txtAlertTitle.text = getString(R.string.high_stress_alert_title)
                    b.txtAlertTitle.setTextColor("#EF4444".toColorInt())
                    b.txtAlertMessage.text = "High stress indicators (${checkIn.indicatorsCsv}). Recommendation: ${checkIn.recommendationsCsv}"
                } else if (checkIn.stressScore >= 50) {
                    b.txtAlertTitle.text = "⚠️ Moderate Stress Alert"
                    b.txtAlertTitle.setTextColor("#F59E0B".toColorInt())
                    b.txtAlertMessage.text = "Moderate stress level detected (${checkIn.indicatorsCsv}). Take a short relaxation break."
                } else {
                    b.txtAlertTitle.text = "🌿 Wellness Status Normal"
                    b.txtAlertTitle.setTextColor("#10B981".toColorInt())
                    b.txtAlertMessage.text = "Your mental wellness indicators are balanced today. Keep up your healthy routine!"
                }
            }
        }

        // Observe latest lifestyle tracking for real-time sleep & mood updates
        db.checkInDao().getLatestLifestyle().observe(viewLifecycleOwner) { lifestyle ->
            val b = _binding ?: return@observe
            if (lifestyle != null) {
                b.txtSleepValue.text = getString(R.string.sleep_hrs_format, lifestyle.sleepHrs)
                b.txtEnergyValue.text = lifestyle.energyLevel
                b.txtMoodEmoji.text = getString(R.string.mood_state_format, lifestyle.moodEmoji)
            }
        }

        binding.btnQuickCheckIn.setOnClickListener {
            (activity as? MainActivity)?.navigateToTab(R.id.nav_checkin)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
