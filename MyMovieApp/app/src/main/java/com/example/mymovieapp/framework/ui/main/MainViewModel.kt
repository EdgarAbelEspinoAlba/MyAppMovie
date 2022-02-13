package com.example.mymovieapp.framework.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovieapp.domain.Movie
import com.example.mymovieapp.usescase.LoadAllMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loadAllMovies: LoadAllMovies
) : ViewModel() {
    private val _progressVisible = MutableLiveData<Boolean>()
    val progressVisible: LiveData<Boolean> get() = _progressVisible

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    private val _showMessage = MutableLiveData<Movie>()
    val showMessage: LiveData<Movie> get() = _showMessage

    fun onCreate() {
        viewModelScope.launch(Dispatchers.Main) {
            _progressVisible.value = true
            _movies.value = loadAllMovies.invoke()
            _progressVisible.value = false
        }
    }

    fun onMovieClicked(movie: Movie) {
        _showMessage.value = movie
    }
}