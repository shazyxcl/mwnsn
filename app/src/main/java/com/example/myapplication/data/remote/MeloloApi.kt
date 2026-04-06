package com.example.myapplication.data.remote

import com.example.myapplication.data.model.*
import retrofit2.http.GET
import retrofit2.http.Query

interface MeloloApi {
    @GET("api/melolo/latest")
    suspend fun getLatest(): ListResponse

    @GET("api/melolo/trending")
    suspend fun getTrending(): ListResponse

    @GET("api/melolo/search")
    suspend fun search(@Query("query") query: String): ListResponse

    @GET("api/melolo/detail")
    suspend fun getDetail(@Query("bookId") bookId: String): DetailResponse

    @GET("api/melolo/stream")
    suspend fun getStream(@Query("videoId") videoId: String): StreamResponse
}