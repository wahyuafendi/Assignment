package com.example.myapplication.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.JokeAdapter
import com.example.myapplication.R
import com.example.myapplication.ViewModel.JokeViewModel

// MainActivity.kt
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: JokeViewModel
    private lateinit var adapter: JokeAdapter
    private lateinit var recyclerViewJokes: RecyclerView
    private lateinit var editTextSearch: EditText
    private lateinit var buttonSearch: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewJokes = findViewById(R.id.recyclerViewJokes)
        editTextSearch = findViewById(R.id.editTextSearch)
        buttonSearch = findViewById(R.id.buttonSearch)

        viewModel = ViewModelProvider(this).get(JokeViewModel::class.java)
        adapter = JokeAdapter(emptyList())
        recyclerViewJokes.layoutManager = LinearLayoutManager(this)
        recyclerViewJokes.adapter = adapter

        buttonSearch.setOnClickListener {
            val query = editTextSearch.text.toString().trim()
            if (query.isNotEmpty()) {
                viewModel.searchJokes(query).observe(this, Observer { jokes ->
                    adapter.apply {
                        jokes?.let { updateJokes(it) }
                        notifyDataSetChanged()
                    }
                })
            }
        }
    }
}
