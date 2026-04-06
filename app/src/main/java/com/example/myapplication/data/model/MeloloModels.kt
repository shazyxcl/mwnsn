package com.example.myapplication.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListResponse(
    val books: List<Book>
)

@JsonClass(generateAdapter = true)
data class Book(
    @Json(name = "book_id") val bookId: String,
    @Json(name = "book_name") val title: String,
    @Json(name = "thumb_url") val thumbnail: String,
    val abstract: String?,
    val author: String?
)

@JsonClass(generateAdapter = true)
data class DetailResponse(
    val code: Int,
    val data: DetailData
)

@JsonClass(generateAdapter = true)
data class DetailData(
    @Json(name = "series_title") val title: String,
    @Json(name = "series_intro") val synopsis: String,
    @Json(name = "video_list") val episodes: List<Episode>
)

@JsonClass(generateAdapter = true)
data class Episode(
    val vid: String,
    val title: String,
    val cover: String?,
    @Json(name = "vid_index") val index: Int
)

@JsonClass(generateAdapter = true)
data class StreamResponse(
    val code: Int,
    val data: StreamData
)

@JsonClass(generateAdapter = true)
data class StreamData(
    @Json(name = "main_url") val mainUrl: String,
    @Json(name = "backup_url") val backupUrl: String?
)