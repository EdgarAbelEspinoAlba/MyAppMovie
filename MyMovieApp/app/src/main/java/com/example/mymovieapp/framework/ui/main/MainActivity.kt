package com.example.mymovieapp.framework.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymovieapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var moviesAdapter: MoviesAdapter
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        moviesAdapter = MoviesAdapter(viewModel::onMovieClicked)
        loadElements()
        val view = binding.root
        setContentView(view)
        viewModel.onCreate()
    }

    private fun loadElements() {
        with(binding) {
            this.recycler.adapter = moviesAdapter

            viewModel.movies.observe(this@MainActivity) { movies ->
                moviesAdapter.movies = movies
            }

            viewModel.progressVisible.observe(this@MainActivity) { value ->
                if (!value) {
                    this.ehaHeader.visibility = View.VISIBLE
                    this.divisor.visibility = View.VISIBLE
                }

                this.progress.visibility = when (value) {
                    true -> View.VISIBLE
                    false -> View.GONE
                }
            }

            viewModel.showMessage.observe(this@MainActivity) {
                Snackbar.make(binding.root,it.overview, Snackbar.LENGTH_LONG)
                    .setAnchorView(binding.progress)
                    .show()
            }
        }
    }
}