package com.example.laboratorio04montes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.laboratorio04montes.R
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var phoneEditText: TextInputEditText
    private lateinit var actionButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.name_value)
        emailEditText = findViewById(R.id.email_value)
        phoneEditText = findViewById(R.id.phone_value)
        actionButton = findViewById(R.id.action_button)


        actionButton.setOnClickListener {
            val intent = Intent(this, ShareActivity::class.java)
            intent.putExtra(SHARE_NAME, nameEditText.text.toString())
            intent.putExtra(SHARE_EMAIL, emailEditText.text.toString())
            intent.putExtra(SHARE_PHONE, phoneEditText.text.toString())
            startActivity(intent)
        }
    }

    companion object{
        const val SHARE_NAME = "name"
        const val SHARE_EMAIL = "email"
        const val SHARE_PHONE = "phone"
    }
}