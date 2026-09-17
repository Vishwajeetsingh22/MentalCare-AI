package com.aimentalcare.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.toColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.aimentalcare.app.R
import com.aimentalcare.app.api.ApiClient
import com.aimentalcare.app.api.TextAnalyzeRequest
import com.aimentalcare.app.data.CheckInEntity
import com.aimentalcare.app.data.MentalCareDatabase
import com.aimentalcare.app.databinding.FragmentCheckinBinding
import com.aimentalcare.app.utils.LocalNLPEngine
import com.aimentalcare.app.utils.NotificationHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CheckInFragment : Fragment() {

    private var _binding: FragmentCheckinBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAnalyze.setOnClickListener {
            val text = binding.etCheckInText.text.toString().trim()
            if (text.isEmpty()) {
                Toast.makeText(requireContext(), R.string.checkin_empty_error, Toast.LENGTH_SHORT).show()
            } else {
                performAnalysis(text)
            }
        }

        binding.btnCrisisHelp.setOnClickListener {
            (activity as? MainActivity)?.navigateToTab(R.id.nav_support)
        }
    }

    private fun performAnalysis(userText: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            var level = "LOW"
            var desc = "Normal"
            var score = 25
            var conf = 90.0
            var indicators = listOf<String>()
            var isCrisis = false
            var recommendations = listOf<String>()

            try {
                // Try REST API backend endpoint
                val res = ApiClient.service.analyzeText(TextAnalyzeRequest(text = userText))
                if (res.isSuccessful && res.body() != null) {
                    val body = res.body()!!
                    level = body.stressLevel
                    desc = body.statusDescription
                    score = body.stressScore
                    conf = body.confidence
                    indicators = body.indicators
                    isCrisis = body.isCrisis
                    recommendations = body.recommendations
                } else {
                    // Local Engine fallback
                    val local = LocalNLPEngine.analyzeText(userText)
                    level = local.stressLevel
                    desc = local.statusDescription
                    score = local.stressScore
                    conf = local.confidence
                    indicators = local.indicators
                    isCrisis = local.isCrisis
                    recommendations = local.recommendations
                }
            } catch (e: Exception) {
                // Local Engine fallback if offline
                val local = LocalNLPEngine.analyzeText(userText)
                level = local.stressLevel
                desc = local.statusDescription
                score = local.stressScore
                conf = local.confidence
                indicators = local.indicators
                isCrisis = local.isCrisis
                recommendations = local.recommendations
            }

            // Save to Room DB
            val db = MentalCareDatabase.getDatabase(requireContext())
            db.checkInDao().insertCheckIn(
                CheckInEntity(
                    userText = userText,
                    stressLevel = level,
                    statusDescription = desc,
                    stressScore = score,
                    confidence = conf,
                    indicatorsCsv = indicators.joinToString(", "),
                    isCrisis = isCrisis,
                    recommendationsCsv = recommendations.joinToString(" | ")
                )
            )

            // Trigger Notification if High or Critical
            if (score >= 75 || isCrisis) {
                NotificationHelper.sendAlertNotification(
                    requireContext(),
                    getString(R.string.high_stress_notification_title),
                    getString(R.string.high_stress_notification_message_format, level, score)
                )
            }

            withContext(Dispatchers.Main) {
                displayResult(level, desc, score, conf, indicators, isCrisis, recommendations)
            }
        }
    }

    private fun displayResult(
        level: String,
        desc: String,
        score: Int,
        conf: Double,
        indicators: List<String>,
        isCrisis: Boolean,
        recommendations: List<String>
    ) {
        binding.cardResultContainer.visibility = View.VISIBLE
        binding.txtResultConfidence.text = getString(R.string.confidence_format, conf.toInt())
        binding.txtResultLevel.text = getString(R.string.result_level_format, level, score)
        binding.txtResultDescription.text = desc

        val badgeColor = when (level) {
            "LOW" -> "#10B981"
            "MODERATE" -> "#F59E0B"
            "HIGH" -> "#EF4444"
            else -> "#991B1B"
        }
        binding.txtResultLevel.setTextColor(badgeColor.toColorInt())

        val indText = StringBuilder()
        indicators.forEach { indText.append("• ").append(it).append("\n") }
        binding.txtResultIndicators.text = indText.toString().trim()

        val recText = StringBuilder()
        recommendations.forEach { recText.append("• ").append(it).append("\n") }
        binding.txtResultRecommendations.text = recText.toString().trim()

        if (isCrisis) {
            binding.bannerCrisisAlert.visibility = View.VISIBLE
        } else {
            binding.bannerCrisisAlert.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
