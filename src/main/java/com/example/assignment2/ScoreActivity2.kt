package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

// File name: ScoreActivity.kt
class ScoreActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score2)

        val score = intent.getIntExtra("score" , 0)
        val txtScore = findViewById<TextView>(R.id.Score)
        val txtFeedback = findViewById<TextView>(R.id.FinalFeedback)
        val btnReview = findViewById<Button>(R.id.feedbackButton)


        txtScore.text = "You got $score out of 5"

        txtFeedback.text = if (score >= 3) {
            "Great job!"
        } else {
            "Keep practising!"
        }

        btnReview.setOnClickListener {
            Toast.makeText(this, "Reviewing questions", Toast.LENGTH_SHORT).show()
            val intent = Intent(this , ReviewQuestions::class.java)
            startActivity(intent)
            finish()

        }


    }
}

