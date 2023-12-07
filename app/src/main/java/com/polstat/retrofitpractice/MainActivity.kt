package com.polstat.retrofitpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var apiService: BookApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = ApiClient.retrofit.create(BookApiService::class.java)
        getBooks()
    }

    private fun getBooks() {
        val call = apiService.getBooks()
        call.enqueue(object: Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                if (response.isSuccessful) {
                    val books = response.body()
                    for (book in books!!) {
                        Log.d(TAG, "Title: ${book.title}, Author: ${book.author}")
                    }
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Log.e(TAG, "Error fetching books", t)
            }
        })
    }
}