package com.aimentalcare.app.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aimentalcare.app.R
import com.aimentalcare.app.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val name = binding.etFullName.text.toString().trim()
            val email = binding.etRegEmail.text.toString().trim()
            val pass = binding.etRegPassword.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, R.string.register_empty_error, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, R.string.register_success, Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        binding.txtLoginLink.setOnClickListener {
            finish()
        }
    }
}
