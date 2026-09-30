package com.aimentalcare.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.aimentalcare.app.R
import com.aimentalcare.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentTabId: Int = R.id.nav_dashboard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            replaceFragment(DashboardFragment())
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            if (item.itemId != currentTabId) {
                currentTabId = item.itemId
                when (item.itemId) {
                    R.id.nav_dashboard -> replaceFragment(DashboardFragment())
                    R.id.nav_checkin -> replaceFragment(CheckInFragment())
                    R.id.nav_analytics -> replaceFragment(AnalyticsFragment())
                    R.id.nav_lifestyle -> replaceFragment(LifestyleFragment())
                    R.id.nav_support -> replaceFragment(SupportFragment())
                }
            }
            true
        }

        binding.btnNavProfile.setOnClickListener {
            replaceFragment(ProfileFragment())
        }

        binding.btnNavAbout.setOnClickListener {
            replaceFragment(AboutFragment())
        }
    }

    fun navigateToTab(tabId: Int) {
        binding.bottomNavigation.selectedItemId = tabId
    }

    fun replaceFragment(fragment: Fragment) {
        if (isFinishing || isDestroyed) return
        try {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commitAllowingStateLoss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
