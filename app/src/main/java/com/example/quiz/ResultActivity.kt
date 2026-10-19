package com.example.quiz

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private val TAG = "ResultActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name = intent.getStringExtra("EXTRA_NAME") ?: ""
        val score = intent.getIntExtra("EXTRA_SCORE", 0)
        val total = intent.getIntExtra("EXTRA_TOTAL", 0)
        Log.d(TAG, "onCreate, получено: $name, $score из $total")

        val tvName = findViewById<TextView>(R.id.tvResultName)
        val tvScore = findViewById<TextView>(R.id.tvResultScore)
        val btnAgain = findViewById<Button>(R.id.btnAgain)

        tvName.text = name
        tvScore.text = getString(R.string.result_score, score, total)

        btnAgain.setOnClickListener {
            Log.i(TAG, "Нажата кнопка «Заново»")
            finish()   // закрываем экран, под ним остался MainActivity
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