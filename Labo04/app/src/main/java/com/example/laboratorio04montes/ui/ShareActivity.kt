package com.example.laboratorio04montes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.laboratorio04montes.R

class ShareActivity : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        nameTextView = findViewById(R.id.name_textview)
        emailTextView = findViewById(R.id.email_textview)
        phoneTextView = findViewById(R.id.phone_textview)
        shareButton = findViewById(R.id.share_button)

        val nameShared = intent.getStringExtra(MainActivity.SHARE_NAME).toString()
        val emailShared = intent.getStringExtra(MainActivity.SHARE_EMAIL).toString()
        val phoneShared = intent.getStringExtra(MainActivity.SHARE_PHONE).toString()
        nameTextView.text = "Nombre: ${nameShared}"
        emailTextView.text = "Correo Electrónico: ${emailShared}"
        phoneTextView.text = "Número de Teléfono: ${phoneShared}"


        shareButton.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)

        }
    }
}