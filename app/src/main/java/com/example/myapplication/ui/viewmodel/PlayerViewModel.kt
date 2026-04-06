package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repository.MeloloRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlayerViewModel(private val videoId: String) : ViewModel() {
    private val repo = MeloloRepository()

    private val _streamUrl = MutableStateFlow<String?>(null)
    val streamUrl = _streamUrl.asStateFlow()

    init {
        loadStream()
    }

    private fun loadStream() {
        viewModelScope.launch {
            try {
                val response = repo.getStream(videoId)
                if (response.code == 200) {
                    _streamUrl.value = response.data.mainUrl
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}