package com.example.laboratorio03montes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var fivecentsImageView: ImageView
    private lateinit var tencentsImageView: ImageView
    private lateinit var quarterImageView: ImageView
    private lateinit var onedollarImageView: ImageView
    private lateinit var cashTextView: TextView

    private var cash = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fivecentsImageView = findViewById(R.id.five_cents)
        tencentsImageView = findViewById(R.id.ten_cents)
        quarterImageView = findViewById(R.id.quarter)
        onedollarImageView = findViewById(R.id.one_dollar)
        cashTextView = findViewById(R.id.cash)


        fivecentsImageView.setOnClickListener {
            cash += 0.05
            cash = String.format("%2f", cash).toDouble()
            cashTextView.text = "${cash}"
        }

        tencentsImageView.setOnClickListener {
            cash += 0.10
            cash = String.format("%2f", cash).toDouble()
            cashTextView.text = "${cash}"
        }

        quarterImageView.setOnClickListener {
            cash += 0.25
            cash = String.format("%2f", cash).toDouble()
            cashTextView.text = "${cash}"
        }

        onedollarImageView.setOnClickListener {
            cash += 1.00
            cash = String.format("%2f", cash).toDouble()
            cashTextView.text = "${cash}"
        }


    }
}