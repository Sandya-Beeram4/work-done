package com.example.constraintlayout

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity() {
    val TAG = "ThirdActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        Log.d("ThirdActivity", "Created Third Activity")
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

