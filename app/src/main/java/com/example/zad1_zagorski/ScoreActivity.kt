package com.example.zad1_zagorski

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        val score = intent.getIntExtra("score", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)
        val resultTextView: TextView = findViewById(R.id.scoreTextView)
        resultTextView.text = "Uzyskany wynik: $score/10"
        }
    }