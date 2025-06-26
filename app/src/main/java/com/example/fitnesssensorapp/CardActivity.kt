package com.example.fitnesssensorapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.hide()
        val bmi = findViewById<ImageView>(R.id.BMIImage)
        val track = findViewById<ImageView>(R.id.ActTrack)

        bmi.setOnClickListener {
            val i = Intent(this, BMIActivity::class.java)
            startActivity(i)
        }

        track.setOnClickListener {
            val i2 = Intent(this, ActTrack::class.java)
            startActivity(i2)
        }
    }
}