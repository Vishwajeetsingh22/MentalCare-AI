package com.aimentalcare.app.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aimentalcare.app.R
import com.aimentalcare.app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val pass = binding.etPassword.text.toString().trim()

            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, R.string.login_empty_error, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, getString(R.string.welcome_back_format, email), Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        binding.txtRegisterLink.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
