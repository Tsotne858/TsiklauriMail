package com.example.tsiklaurimail

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MessageActivity : AppCompatActivity() {

    private lateinit var fromEditText: EditText
    private lateinit var toEditText: EditText
    private lateinit var messageEditText: EditText
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        fromEditText = findViewById(R.id.fromEditText)
        toEditText = findViewById(R.id.toEditText)
        messageEditText = findViewById(R.id.messageEditText)
        clearButton = findViewById(R.id.clearButton)

        val fromEmail = intent.getStringExtra("FROM_EMAIL") ?: "user@example.com"
        val toEmail = intent.getStringExtra("TO_EMAIL") ?: "recipient@example.com"
        val message = intent.getStringExtra("MESSAGE") ?: "No message"

        fromEditText.setText(fromEmail)
        toEditText.setText(toEmail)
        messageEditText.setText(message)

        clearButton.setOnClickListener {
            clearFields()
        }
    }

    private fun clearFields() {
        fromEditText.text.clear()
        toEditText.text.clear()
        messageEditText.text.clear()
    }
}
