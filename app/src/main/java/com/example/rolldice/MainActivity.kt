package com.example.rolldice

import android.media.Image
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rollDice: Button = findViewById(R.id.roll_dice_button)
        val firstDice: ImageView = findViewById(R.id.first_dice_imageview)
        val secondDice: ImageView = findViewById(R.id.second_dice_imageview)
        val thirdDice: ImageView = findViewById(R.id.third_dice_imageview)
        val fourthDice: ImageView = findViewById(R.id.fourth_dice_imageview)
        val fifthDice: ImageView = findViewById(R.id.fifth_dice_imageview)

        val diceImages = mapOf(
            1 to R.drawable.one,
            2 to R.drawable.two,
            3 to R.drawable.three,
            4 to R.drawable.four,
            5 to R.drawable.five

        )


        rollDice.setOnClickListener {
            val randomNumberList: List<Int> = List(5){(1..6).random()}
            val (first, second, third, fourth, fifth) = randomNumberList
            firstDice.setImageResource(diceImages[first] ?: R.drawable.question)
            secondDice.setImageResource(diceImages[second] ?: R.drawable.question)
            thirdDice.setImageResource(diceImages[third] ?: R.drawable.question)
            fourthDice.setImageResource(diceImages[fourth] ?: R.drawable.question)
            fifthDice.setImageResource(diceImages[fifth] ?: R.drawable.question)

        }

    }
}