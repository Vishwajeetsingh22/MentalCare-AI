package com.aimentalcare.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.aimentalcare.app.R
import com.aimentalcare.app.api.ApiClient
import com.aimentalcare.app.api.BurnoutRequest
import com.aimentalcare.app.data.MentalCareDatabase
import com.aimentalcare.app.databinding.FragmentAnalyticsBinding
import com.aimentalcare.app.utils.LocalNLPEngine
import com.aimentalcare.app.utils.NotificationHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnalyticsFragment : Fragment() {

    private var _binding: FragmentAnalyticsBinding? = null
    private val binding get() = _binding!!

    private var historicalScores = listOf(35, 48, 62, 71, 79, 84)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnalyticsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadAnalyticsData()
        binding.btnRecalculateBurnout.setOnClickListener {
            runBurnoutScan()
        }
    }

    private fun loadAnalyticsData() {
        val appCtx = context?.applicationContext ?: return
        lifecycleScope.launch(Dispatchers.IO) {
            val db = MentalCareDatabase.getDatabase(appCtx)
            val recent = db.checkInDao().getRecentCheckIns()
            if (recent.size >= 3) {
                historicalScores = recent.map { it.stressScore }.reversed()
            }

            withContext(Dispatchers.Main) {
                val b = _binding ?: return@withContext
                b.stressChartView.setScores(historicalScores)
                val avg = if (historicalScores.isNotEmpty()) historicalScores.average().toInt() else 0
                b.txt7DayAvg.text = getString(R.string.avg_7_day_format, avg)

                val sb = StringBuilder()
                historicalScores.forEachIndexed { idx, s ->
                    sb.append("Day ${idx + 1} ($s%)")
                    if (idx < historicalScores.size - 1) sb.append(" -> ")
                }
                b.txtBurnoutProgression.text = sb.toString()

                runBurnoutScan()
            }
        }
    }

    private fun runBurnoutScan() {
        val appCtx = context?.applicationContext ?: return
        lifecycleScope.launch(Dispatchers.IO) {
            var risk = "HIGH"
            var isBurnout = true
            var msg = "Increasing stress pattern detected! Avg 76%. High risk of cumulative burnout."

            try {
                val res = ApiClient.service.analyzeBurnout(BurnoutRequest(historicalScores))
                if (res.isSuccessful && res.body() != null) {
                    val body = res.body()!!
                    risk = body.burnoutRisk
                    isBurnout = body.isBurnoutPattern
                    msg = body.trendMessage
                } else {
                    val local = LocalNLPEngine.analyzeBurnout(historicalScores)
                    risk = local.burnoutRisk
                    isBurnout = local.isBurnoutPattern
                    msg = local.trendMessage
                }
            } catch (e: Exception) {
                val local = LocalNLPEngine.analyzeBurnout(historicalScores)
                risk = local.burnoutRisk
                isBurnout = local.isBurnoutPattern
                msg = local.trendMessage
            }

            if (isBurnout) {
                NotificationHelper.sendAlertNotification(
                    appCtx,
                    getString(R.string.burnout_notification_title),
                    getString(R.string.burnout_notification_message)
                )
            }

            withContext(Dispatchers.Main) {
                val b = _binding ?: return@withContext
                b.txtBurnoutBadge.text = getString(R.string.risk_format, risk)
                b.txtBurnoutMessage.text = msg
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
