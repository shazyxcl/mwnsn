package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.DetailData
import com.example.myapplication.data.repository.MeloloRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val bookId: String) : ViewModel() {
    private val repo = MeloloRepository()

    private val _detail = MutableStateFlow<DetailData?>(null)
    val detail = _detail.asStateFlow()

    init {
        loadDetail()
    }

    private fun loadDetail() {
        viewModelScope.launch {
            try {
                val response = repo.getDetail(bookId)
                if (response.code == 200) {
                    _detail.value = response.data
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}