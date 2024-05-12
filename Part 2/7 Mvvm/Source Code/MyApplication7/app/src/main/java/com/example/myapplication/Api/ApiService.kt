package com.example.myapplication.Api

import com.example.myapplication.Model.JokeResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("jokes/search")
    fun searchJokes(@Query("query") query: String): Call<JokeResponse>

    companion object {
        private const val BASE_URL = "https://api.chucknorris.io/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}