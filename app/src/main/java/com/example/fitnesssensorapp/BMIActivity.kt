package com.example.fitnesssensorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BMIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bmiactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val height = findViewById<EditText>(R.id.editHeight)
        val weight = findViewById<EditText>(R.id.editWeight)
        val bmicalc = findViewById<Button>(R.id.btnBMI)
        val resbmi = findViewById<TextView>(R.id.BMIres)

        bmicalc.setOnClickListener{
            val h = (height.text.toString()).toFloat()/100
            val w = (weight.text.toString()).toFloat()

            val r = w/(h*h)
            resbmi.text = "Your Calculated BMI is $r"
        }
    }
}