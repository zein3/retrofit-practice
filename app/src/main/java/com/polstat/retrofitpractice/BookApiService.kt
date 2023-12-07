package com.polstat.retrofitpractice

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface BookApiService {
    @GET("/books")
    fun getBooks(): Call<List<Book>>

    @GET("/books/{id}")
    fun getBookById(@Path("id") id: Int): Call<Book>

    @POST("/books")
    fun createBook(@Body book: Book)

    @PUT("/books/{id}")
    fun updateBook(@Path("id") id: Int, @Body book: Book): Call<Book>

    @DELETE("/books/{id}")
    fun deletBook(@Path("id") id: Int): Call<Unit>
}