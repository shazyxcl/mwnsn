package com.example.myapplication.data.repository

import com.example.myapplication.data.model.*
import com.example.myapplication.util.RetrofitInstance

class MeloloRepository {
    private val api = RetrofitInstance.api

    suspend fun getLatest() = api.getLatest()
    suspend fun getTrending() = api.getTrending()
    suspend fun search(query: String) = api.search(query)
    suspend fun getDetail(bookId: String) = api.getDetail(bookId)
    suspend fun getStream(videoId: String) = api.getStream(videoId)
}