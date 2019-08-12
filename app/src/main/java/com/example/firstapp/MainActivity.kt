package com.example.firstapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImageFirst: ImageView
    lateinit var diceImageSecond: ImageView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImageFirst = findViewById(R.id.dice_image_1)
        diceImageSecond = findViewById(R.id.dice_image_2)

        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener { rollDice() }
    }

    private fun randomNumber(): Int {
        return Random().nextInt(6) + 1
    }

    private fun rollDice() {
        val firstDice = getDiceImage()
        diceImageFirst.setImageResource(firstDice)

        var secondDice = getDiceImage()
        while (secondDice == firstDice) {
            secondDice = getDiceImage()
        }
        diceImageSecond.setImageResource(secondDice)
    }

    private fun getDiceImage(): Int {
        return  when (randomNumber()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
