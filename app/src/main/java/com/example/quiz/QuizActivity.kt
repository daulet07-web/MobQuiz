package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private val TAG = "QuizActivity"

    // вопросы, варианты ответов и номер верного ответа (с нуля)
    private val questions = arrayOf(
        "На каком языке написано это приложение?",
        "Как называется файл-паспорт приложения?",
        "Какой метод вызывается первым при создании экрана?"
    )
    private val answers = arrayOf(
        arrayOf("Java", "Kotlin", "Python"),
        arrayOf("AndroidManifest.xml", "colors.xml", "MainActivity.kt"),
        arrayOf("onStop", "onDestroy", "onCreate")
    )
    private val correct = intArrayOf(1, 0, 2)

    private var current = 0   // номер текущего вопроса
    private var score = 0     // количество верных ответов
    private var name = ""

    private lateinit var tvNumber: TextView
    private lateinit var tvPlayer: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var btnAnswer1: Button
    private lateinit var btnAnswer2: Button
    private lateinit var btnAnswer3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        name = intent.getStringExtra("EXTRA_NAME") ?: ""
        Log.d(TAG, "onCreate, получено имя: $name")

        tvNumber = findViewById(R.id.tvNumber)
        tvPlayer = findViewById(R.id.tvPlayer)
        tvQuestion = findViewById(R.id.tvQuestion)
        btnAnswer1 = findViewById(R.id.btnAnswer1)
        btnAnswer2 = findViewById(R.id.btnAnswer2)
        btnAnswer3 = findViewById(R.id.btnAnswer3)

        tvPlayer.text = name

        btnAnswer1.setOnClickListener { checkAnswer(0) }
        btnAnswer2.setOnClickListener { checkAnswer(1) }
        btnAnswer3.setOnClickListener { checkAnswer(2) }

        showQuestion()
    }

    private fun showQuestion() {
        tvNumber.text = getString(R.string.question_number, current + 1, questions.size)
        tvQuestion.text = questions[current]
        btnAnswer1.text = answers[current][0]
        btnAnswer2.text = answers[current][1]
        btnAnswer3.text = answers[current][2]
        Log.d(TAG, "Показан вопрос ${current + 1}")
    }

    private fun checkAnswer(choice: Int) {
        if (choice == correct[current]) {
            score++
            Log.i(TAG, "Вопрос ${current + 1}: ответ верный")
        } else {
            Log.i(TAG, "Вопрос ${current + 1}: ответ неверный")
        }

        current++

        if (current < questions.size) {
            showQuestion()
        } else {
            Log.i(TAG, "Вопросы закончились, счёт: $score")
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("EXTRA_NAME", name)
            intent.putExtra("EXTRA_SCORE", score)
            intent.putExtra("EXTRA_TOTAL", questions.size)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}