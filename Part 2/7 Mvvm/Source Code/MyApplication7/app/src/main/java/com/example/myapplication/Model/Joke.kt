package com.example.myapplication.Model
// Joke.kt
data class Joke(
    val categories: List<String>,
    val createdAt: String,
    val iconUrl: String,
    val id: String,
    val updatedAt: String,
    val url: String,
    val value: String
)

data class JokeResponse(
    val total: Int,
    val result: List<Joke>
)
