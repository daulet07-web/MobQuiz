package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        val etName = findViewById<EditText>(R.id.etName)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnClear = findViewById<Button>(R.id.btnClear)

        btnStart.setOnClickListener {
            val name = etName.text.toString().trim()
            if (name.isEmpty()) {
                Log.w(TAG, "Имя не введено")
                Toast.makeText(this, R.string.error_empty_name, Toast.LENGTH_SHORT).show()
            } else {
                Log.i(TAG, "Начинаем викторину, имя: $name")
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }
        }

        btnClear.setOnClickListener {
            etName.setText("")
            Log.i(TAG, "Поле имени очищено")
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