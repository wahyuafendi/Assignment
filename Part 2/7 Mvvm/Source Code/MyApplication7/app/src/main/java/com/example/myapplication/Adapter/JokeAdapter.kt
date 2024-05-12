package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.Joke
import com.example.myapplication.R

// JokeAdapter.kt
class JokeAdapter(private var jokes: List<Joke>) : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    fun updateJokes(newJokes: List<Joke>) {
        jokes = newJokes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false)
        return JokeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = jokes.getOrNull(position) // Use getOrNull to avoid NullPointerException
        joke?.let { holder.bind(it) } // Only bind if joke is not null
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    inner class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewJoke: TextView = itemView.findViewById(R.id.textViewJoke)

        fun bind(joke: Joke) {
            textViewJoke.text = joke.value
        }
    }
}
