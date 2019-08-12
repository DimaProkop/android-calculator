package com.example.firstapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val countUpButton: Button = findViewById(R.id.count_button)
        val resultText: TextView = findViewById(R.id.result_text)

        rollButton.setOnClickListener { resultText.text = (randomNumber()).toString() }

        countUpButton.setOnClickListener { resultText.text = countUp(resultText.text).toString() }
    }

    private fun randomNumber(): Int {
        return Random().nextInt(6) + 1
    }

    private fun countUp(currentText: CharSequence): Int {
        if (currentText.isEmpty() || currentText.isBlank() || currentText.toString().length > 1) {
            return 1
        }

        var answer = Integer.parseInt(currentText.toString())

        if (answer == 6) {
            return answer
        }

        return ++answer
    }

    private fun showToastByClick() {
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
    }
}
