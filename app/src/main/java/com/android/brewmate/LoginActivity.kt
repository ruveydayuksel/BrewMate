package com.android.brewmate

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    // Doğru kullanıcı bilgileri
    private val correctEmail = "test@te.st"
    private val correctPassword = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailInput = findViewById<TextInputEditText>(R.id.emailInput)
        val passwordInput = findViewById<TextInputEditText>(R.id.passwordInput)
        val nextButton = findViewById<android.widget.Button>(R.id.nextButton)
        val newMember = findViewById<ImageView>(R.id.newMember)

        newMember.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        nextButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (!CredentialsManager.isEmailValid(email)) {
                emailInput.error = "Invalid email format"
            } else if (!CredentialsManager.isPasswordValid(password)) {
                passwordInput.error = "Password cannot be empty"
            } else if (email == correctEmail && password == correctPassword) {
                emailInput.error = null
                passwordInput.error = null
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Yanlış bilgiler
                Toast.makeText(this, "Incorrect email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}