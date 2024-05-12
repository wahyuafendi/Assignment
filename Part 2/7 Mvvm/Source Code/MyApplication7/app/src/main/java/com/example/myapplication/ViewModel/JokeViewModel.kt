package com.example.myapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Helper.JokeRepository
import com.example.myapplication.Model.Joke

class JokeViewModel : ViewModel() {
    private val jokeRepository = JokeRepository()

    fun searchJokes(query: String): LiveData<List<Joke>> {
        return jokeRepository.searchJokes(query)
    }
}
