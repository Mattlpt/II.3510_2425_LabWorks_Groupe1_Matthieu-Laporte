package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var textViewDisplay: TextView
    private lateinit var buttonSubmit: Button
    private lateinit var buttonChangeColor: Button
    private lateinit var buttonIncreaseSize: Button
    private lateinit var buttonDecreaseSize: Button

    private var isColorRed = false
    private var textSize = 16f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        textViewDisplay = findViewById(R.id.textViewDisplay)
        buttonSubmit = findViewById(R.id.buttonSubmit)
        buttonChangeColor = findViewById(R.id.buttonChangeColor)
        buttonIncreaseSize = findViewById(R.id.buttonIncreaseSize)
        buttonDecreaseSize = findViewById(R.id.buttonDecreaseSize)

        buttonSubmit.setOnClickListener {
            val inputText = editText.text.toString()
            textViewDisplay.text = inputText
        }

        buttonChangeColor.setOnClickListener {
            if (isColorRed) {
                textViewDisplay.setTextColor(Color.BLACK)
            } else {
                textViewDisplay.setTextColor(Color.RED)
            }
            isColorRed = !isColorRed
        }

        buttonIncreaseSize.setOnClickListener {
            textSize += 2f
            textViewDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
        }

        buttonDecreaseSize.setOnClickListener {
            if (textSize > 10f) {
                textSize -= 2f
                textViewDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}


