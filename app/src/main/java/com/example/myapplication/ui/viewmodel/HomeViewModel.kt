package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.Book
import com.example.myapplication.data.repository.MeloloRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repo = MeloloRepository()

    private val _latest = MutableStateFlow<List<Book>>(emptyList())
    val latest = _latest.asStateFlow()

    private val _trending = MutableStateFlow<List<Book>>(emptyList())
    val trending = _trending.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            try {
                _latest.value = repo.getLatest().books
                _trending.value = repo.getTrending().books
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}