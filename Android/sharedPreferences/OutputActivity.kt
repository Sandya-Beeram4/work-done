package com.example.constraintlayout

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OutputActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        nameTextView = findViewById(R.id.textViewName)
        emailTextView = findViewById(R.id.textViewEmail)

        // Retrieve data from SharedPreferences
        val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("key_name", "No Name")
        val email = sharedPreferences.getString("key_email", "No Email")

        // Display the data
        nameTextView.text = name
        emailTextView.text = email
    }
}
