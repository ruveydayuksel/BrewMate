package com.android.brewmate

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // LoginActivity'ye yönlendirme
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

        // MainActivity'yi kapatıyoruz, böylece geri tuşuyla buraya dönülmez.
        finish()
    }
}