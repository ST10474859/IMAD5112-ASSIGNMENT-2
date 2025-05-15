package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ReviewQuestions : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_questions)

        val btnExit = findViewById<Button>(R.id.exitButton)
        val textReview = findViewById<TextView>(R.id.textReview)
        val tryagainbutton = findViewById<Button>(R.id.tryAgain)

        textReview.text = ""
        "Nelson Mandela was the president in 1994, True"
        "World War II ended in 1945, True"
        "The Roman Empire fell in 476 AD, True"
        "The Berlin Wall fell in 1989, True"
        "The Great Fire of London was in 1766, False".trimIndent()

        tryagainbutton.setOnClickListener{
            Toast.makeText(this, "Restarting quiz...!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Questions::class.java)
            finish()

        }
        btnExit.setOnClickListener {
            Toast.makeText(this, "Thank you for playing the quiz", Toast.LENGTH_SHORT).show()
            val intent = Intent(this , ReviewQuestions::class.java)
            startActivity(intent)
            finish()
        }
    }
}