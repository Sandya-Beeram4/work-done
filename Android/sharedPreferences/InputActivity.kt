package com.example.constraintlayout


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class InputActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        nameEditText = findViewById(R.id.editTextName)
        emailEditText = findViewById(R.id.editTextEmail)
        saveButton = findViewById(R.id.buttonSave)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()

            // Save data to SharedPreferences
            val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("key_name", name)
            editor.putString("key_email", email)
            editor.apply()

            // Start the next activity
            val intent = Intent(this, OutputActivity::class.java)
            startActivity(intent)
        }
    }
}
