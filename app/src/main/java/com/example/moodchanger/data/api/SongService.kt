package com.example.moodchanger.data.api

import com.example.moodchanger.data.model.SongResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SongService {

    @GET("api/search/songs")
    suspend fun searchSongs(@Query("query") query: String) : Response<SongResponse>
}