    package com.challenge2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var resultMessage = ""
    var textColor = "#f03e3e"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val input = findViewById<EditText>(R.id.input)
        val palindromeCheck = findViewById<Button>(R.id.palindromeCheck)
        val pangramCheck = findViewById<Button>(R.id.pangramCheck)


        palindromeCheck.setOnClickListener{
            val inputText = input.text.toString()

            val isPalindrome = inputText == inputText.reversed()

            if(isPalindrome){
                resultMessage = "$inputText is a palindrome"
                textColor = "#40c057"
            } else {
                resultMessage = "$inputText is not a palindrome"
                textColor = "#f03e3e"
            }

            val intent = Intent(this, result::class.java)
            intent.putExtra("result", resultMessage)
            intent.putExtra("textColor", textColor)
            startActivity(intent)

        }

        pangramCheck.setOnClickListener{
            val inputText = input.text.toString()

            val isPangram = inputText.lowercase().toSet().containsAll(('a'..'z').toSet())

            if(isPangram){
                resultMessage = "$inputText is a pangram"
                textColor = "#40c057"
            } else {
                resultMessage = "$inputText is not a pangram"
                textColor = "#f03e3e"
            }

            val intent = Intent(this, result::class.java)
            intent.putExtra("result", resultMessage)
            intent.putExtra("textColor", textColor)
            startActivity(intent)
        }
    }
}