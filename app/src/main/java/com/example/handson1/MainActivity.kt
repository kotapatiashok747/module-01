package com.example.handson1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtMessage: EditText
    private lateinit var btnSend: Button
    private lateinit var txtResponse: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtMessage = findViewById(R.id.edtMessage)
        btnSend = findViewById(R.id.btnSend)
        txtResponse = findViewById(R.id.txtResponse)
        progressBar = findViewById(R.id.progressBar)

        btnSend.setOnClickListener {

            val input = edtMessage.text.toString().trim()

            if (input.isEmpty()) {
                txtResponse.text = "Please enter a message."
                return@setOnClickListener
            }

            progressBar.visibility = View.VISIBLE

            val response = when {

                input.contains("hello", true) ->
                    "Hello! How can I help you?"

                input.contains("ai", true) ->
                    "AI stands for Artificial Intelligence."

                input.contains("electric vehicle", true) ||
                        input.contains("ev", true) ->
                    "An Electric Vehicle (EV) is powered by rechargeable batteries."

                input.contains("light", true) ->
                    "Turning ON Light..."

                input.contains("fan", true) ->
                    "Turning ON Fan..."

                else ->
                    "Sorry, I don't understand your request."
            }

            progressBar.visibility = View.GONE
            txtResponse.text = response
        }
    }
}