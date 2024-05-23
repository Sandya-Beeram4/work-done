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

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

data class User(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)


interface ApiService {
    @GET("comments/{idVal}")
    fun getUser(@Path("idVal") idVal: Int): Call<User>
}



class RetrofitActivity : AppCompatActivity() {
    val TAG = "RetrofitActivity"
    private lateinit var apiService: ApiService



        private lateinit var postIdTextView: TextView
        private lateinit var idTextView: TextView
        private lateinit var nameTextView: TextView
        private lateinit var emailTextView: TextView
        private lateinit var bodyTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)



         postIdTextView = findViewById(R.id.textViewPostId)
        idTextView = findViewById(R.id.textViewId)
        nameTextView = findViewById(R.id.textViewName)
        emailTextView = findViewById(R.id.textViewEmail)
        bodyTextView = findViewById(R.id.textViewBody)

        // TODO: learn about it
        // Initialize Retrofit
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/") // Replace with your base URL
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)

        // Make API call
        fetchUser(200)
    }

    private fun fetchUser(userId: Int) {
        val call = apiService.getUser(userId)
        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    user?.let {
                        Log.d(TAG, "User: ${it.name}, Email: ${it.email}")
                        postIdTextView.text = "Post ID: ${user.postId}"
                        idTextView.text = "ID: ${user.id}"
                        nameTextView.text = "Name: ${user.name}"
                        emailTextView.text = "Email: ${user.email}"
                        bodyTextView.text = "Body: ${user.body}"
                    }
                } else {
                    Log.e(TAG, "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e(TAG, "Failure: ${t.message}")
            }
        })
    }
}
