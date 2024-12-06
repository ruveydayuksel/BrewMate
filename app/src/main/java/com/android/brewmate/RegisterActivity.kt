package com.android.brewmate

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // "Log In" butonuna tıklayınca LoginActivity'ye geri dönüş
        val loginImageView: ImageView = findViewById(R.id.alreadyLogin)
        loginImageView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            // Backstack'te döngüyü önlemek için gerekli bayraklar
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
    }
}