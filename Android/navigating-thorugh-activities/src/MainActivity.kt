package com.example.constraintlayout

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        Log.d("MainActivity", "Created Main Activity")
        //Log.d(TAG, "onCreate: dslkfgslk")
        val secondActButton = findViewById<Button>(R.id.buttonToSecondActivity)
        secondActButton.setOnClickListener {
            val Intent = Intent(this, SecondActivity::class.java)
            startActivity(Intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "On start Main Activity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "On pause Main Activity")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "On resume Main Activity")
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

