package com.example.constraintlayout

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    val TAG = "SecondActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("SecondActivity", "created Second Activity")
        val secondActButton = findViewById<Button>(R.id.buttonToThirdACtivity)
        secondActButton.setOnClickListener {
            val Intent = Intent(this, ThirdActivity::class.java)
            startActivity(Intent)
        }


    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: $TAG")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: $TAG")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: $TAG")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: $TAG")
    }
}