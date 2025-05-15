package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Questions : AppCompatActivity() {
    private val questions = arrayOf(
        "Kaizer Chifs won the Nedbank cup in 2025" ,
        "Orlando Pirates won the Nedbank cup in 2025" ,
        "kaizer chiefs has over 100 million supporters" ,
        "Orlando Pirates lost on the semi finals in egypt" ,
        "sundowns is the best team in mzansi"
    )

    private val answers = arrayOf(true , false , true , true , false)
    private var currentIndex = 0
    private var score = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val txtQuestion = findViewById<TextView>(R.id.textView)
        val btnTrue = findViewById<Button>(R.id.trueButton)
        val btnFalse = findViewById<Button>(R.id.falseButton)
        val btnNext = findViewById<Button>(R.id.nextQuestion)
        val txtFeedback = findViewById<TextView>(R.id.Feedback)

        fun updateQuestion() {
            txtQuestion.text = questions[currentIndex]
            txtFeedback.text = ""
        }

        btnTrue.setOnClickListener {
            checkAnswer(true , txtFeedback)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false , txtFeedback)
        }

        btnNext.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                updateQuestion()
            } else {
            val intent = Intent(this , ScoreActivity2::class.java)
            intent.putExtra("score" , score)
            startActivity(intent)
        }
    }

        updateQuestion()
    }

    private fun checkAnswer(userAnswer: Boolean, feedback: TextView) {
        if (userAnswer == answers[currentIndex]) {
            feedback.text = "Correct!"
            score++
        } else {
            feedback.text = "Incorrect!"


        }
    }
}