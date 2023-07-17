package com.example.espressouitest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button_next_activity)
        val intent = Intent(this, SecondaryActivity::class.java)
        button.setOnClickListener {
            startActivity(intent)
        }


    }
}