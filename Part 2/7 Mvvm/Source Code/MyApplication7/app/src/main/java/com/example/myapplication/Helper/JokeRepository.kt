package com.example.myapplication.Helper



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Model.Joke
import com.example.myapplication.Api.ApiService
import com.example.myapplication.Model.JokeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// JokeRepository.kt
class JokeRepository {
    fun searchJokes(query: String): LiveData<List<Joke>> {
        val jokesLiveData = MutableLiveData<List<Joke>>()
        val apiService = ApiService.create()
        apiService.searchJokes(query).enqueue(object : Callback<JokeResponse> {
            override fun onResponse(call: Call<JokeResponse>, response: Response<JokeResponse>) {
                if (response.isSuccessful) {
                    val jokes = response.body()?.result ?: emptyList()
                    jokesLiveData.postValue(jokes)
                }
            }

            override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                // Handle failure
            }
        })
        return jokesLiveData
    }
}