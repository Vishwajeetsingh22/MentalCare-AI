package com.aimentalcare.app.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.aimentalcare.app.R
import com.aimentalcare.app.databinding.FragmentSupportBinding

class SupportFragment : Fragment() {

    private var _binding: FragmentSupportBinding? = null
    private val binding get() = _binding!!

    private var timer: CountDownTimer? = null
    private var isTimerRunning = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSupportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCallHotline.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:988"))
            startActivity(intent)
        }

        binding.btnContactTrusted.setOnClickListener {
            Toast.makeText(requireContext(), R.string.notifying_contact, Toast.LENGTH_LONG).show()
        }

        binding.btnStartBreathing.setOnClickListener {
            if (isTimerRunning) {
                stopBreathingTimer()
            } else {
                startBreathingTimer()
            }
        }
    }

    private fun startBreathingTimer() {
        isTimerRunning = true
        binding.btnStartBreathing.text = getString(R.string.stop_exercise)

        val phases = listOf(
            getString(R.string.inhale_phase),
            getString(R.string.hold_breath_phase),
            getString(R.string.exhale_phase),
            getString(R.string.hold_empty_phase)
        )
        
        timer = object : CountDownTimer(300000, 1000) { // 5 minutes (300,000 ms)
            override fun onTick(millisUntilFinished: Long) {
                val secRemaining = (millisUntilFinished / 1000).toInt()
                val min = secRemaining / 60
                val sec = secRemaining % 60
                binding.txtBreathingTimer.text = getString(R.string.timer_format, min, sec)

                val phaseIdx = (300 - secRemaining) % 16 / 4
                binding.txtBreathingPhase.text = phases[phaseIdx]
            }

            override fun onFinish() {
                binding.txtBreathingTimer.text = getString(R.string.timer_format, 0, 0)
                binding.txtBreathingPhase.text = getString(R.string.exercise_complete)
                stopBreathingTimer()
            }
        }.start()
    }

    private fun stopBreathingTimer() {
        timer?.cancel()
        isTimerRunning = false
        binding.btnStartBreathing.text = getString(R.string.start_breathing)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer?.cancel()
        _binding = null
    }
}
