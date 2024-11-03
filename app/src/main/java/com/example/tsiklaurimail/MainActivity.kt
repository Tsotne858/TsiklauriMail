package com.example.tsiklaurimail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var recipientEditText: EditText
    private lateinit var messageEditText: EditText
    private lateinit var sendMessageButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        emailEditText = findViewById(R.id.emailEditText)
        recipientEditText = findViewById(R.id.recipientEditText)
        messageEditText = findViewById(R.id.messageEditText)
        sendMessageButton = findViewById(R.id.sendMessageButton)


        sendMessageButton.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        val email = emailEditText.text.toString().trim()
        val recipient = recipientEditText.text.toString().trim()
        val message = messageEditText.text.toString().trim()


        if (email.isEmpty() || recipient.isEmpty() || message.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // Only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient)) // Recipient's email address
            putExtra(Intent.EXTRA_SUBJECT, "Message from $email") // Email subject
            putExtra(Intent.EXTRA_TEXT, message) // Email message body
        }

        if (emailIntent.resolveActivity(packageManager) != null) {
            startActivity(emailIntent)
        } else {
            Toast.makeText(this, "No email app available", Toast.LENGTH_SHORT).show()
        }
    }
}
