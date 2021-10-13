package com.nada.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollerDice()
            //val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            //toast.show()
            //val resultTextView: TextView = findViewById(R.id.txt_result)
            //resultTextView.text = "6"


            Toast.makeText(this, "Dice Roller", Toast.LENGTH_SHORT).show()
    }
        // Do a dice roll when the app starts
        rollerDice()
    }


class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollerDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Update the screen with the dice roll
        //val resultTextView: TextView = findViewById(R.id.txt_result)
        //resultTextView.text = diceRoll.toString()
        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()

    }
}