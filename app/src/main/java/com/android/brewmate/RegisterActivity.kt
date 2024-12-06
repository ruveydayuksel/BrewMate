package com.android.brewmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val fullNameInput = findViewById<TextInputEditText>(R.id.fullName)
        val emailInput = findViewById<TextInputEditText>(R.id.registerEmailLayout)
        val phoneInput = findViewById<TextInputEditText>(R.id.editText3)
        val passwordInput = findViewById<TextInputEditText>(R.id.editText2)
        val registerButton = findViewById<Button>(R.id.textView)
        val alreadyLogin = findViewById<ImageView>(R.id.alreadyLogin)


        alreadyLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        registerButton.setOnClickListener {
            val fullName = fullNameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val phone = phoneInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (fullName.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.length < 6) {
                Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = CredentialsManager.register(email, password)
            if (result.isSuccess) {
                Toast.makeText(this, result.getOrNull(), Toast.LENGTH_SHORT).show()
                // LoginActivity'ye geçiş
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, result.exceptionOrNull()?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}