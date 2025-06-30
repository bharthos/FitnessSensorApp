package com.example.fitnesssensorapp

import android.graphics.Color
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

        bmicalc.setOnClickListener {
            val h = height.text.toString().toFloatOrNull()?.div(100) // convert cm to m
            val w = weight.text.toString().toFloatOrNull()

            if (h != null && w != null && h > 0) {
                val r = w / (h * h)
                val category: String
                val color: Int

                when {
                    r < 18.5 -> {
                        category = "Underweight: BMI is less than 18.5"
                        color = Color.parseColor("#03A9F4") // blue
                    }
                    r < 25 -> {
                        category = "Normal weight: BMI is 18.5 to 24.9"
                        color = Color.parseColor("#4CAF50") // green
                    }
                    r < 30 -> {
                        category = "Overweight: BMI is 25 to 29.9"
                        color = Color.parseColor("#FFC107") // yellow
                    }
                    else -> {
                        category = "Obesity: BMI is 30 or more"
                        color = Color.parseColor("#F44336") // red
                    }
                }

                resbmi.text = "Your Calculated BMI is: %.1f\n$category".format(r)
                resbmi.setTextColor(color)

            } else {
                resbmi.text = "Please enter valid height and weight"
                resbmi.setTextColor(Color.GRAY)
            }
        }

    }
}