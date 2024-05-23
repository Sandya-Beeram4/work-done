package com.example.constraintlayout

import retrofit2.http.GET
import retrofit2.http.Path
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

data class UserC(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)

interface ApiServiceC {
    @GET("comments/{id}")
    suspend fun getUser(@Path("id") id: Int): UserC
}

object RetrofitInstance {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")  // Replace with your base URL
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiServiceC by lazy {
        retrofit.create(ApiServiceC::class.java)
    }
}


class CoroutinesActivity : AppCompatActivity() {
    private lateinit var postIdTextView: TextView
    private lateinit var idTextView: TextView
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var bodyTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        postIdTextView = findViewById(R.id.textViewPostIdC)
        idTextView = findViewById(R.id.textViewIdC)
        nameTextView = findViewById(R.id.textViewNameC)
        emailTextView = findViewById(R.id.textViewEmailC)
        bodyTextView = findViewById(R.id.textViewBodyC)


        // Make a network request using coroutines
        lifecycleScope.launch {
            try {
                val user = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.getUser(500)  // Fetch user with ID 1
                }
                withContext(Dispatchers.Main) {
                    postIdTextView.text = "Post ID: ${user.postId}"
                    idTextView.text = "ID: ${user.id}"
                    nameTextView.text = "Name: ${user.name}"
                    emailTextView.text = "Email: ${user.email}"
                    bodyTextView.text = "Body: ${user.body}"
                }
                // Update UI with user data
                Toast.makeText(this@CoroutinesActivity, "User: ${user.name}, Email: ${user.email}", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                // Handle exceptions
                Toast.makeText(this@CoroutinesActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}


