package com.example.moodchanger.data.repository

import com.example.moodchanger.data.api.SongService
import com.example.moodchanger.data.model.Song
import com.example.moodchanger.utils.APIResult
import retrofit2.http.Query
import javax.inject.Inject

class SongsRepository @Inject constructor(private val songService: SongService) {
    suspend fun fetchSongs(query: String):APIResult<List<Song>>{
        return try {
            val response = songService.searchSongs(query)
            if(response.isSuccessful){
                val results = response.body()?.data?.results ?: emptyList()
                APIResult.Success(results)
            }
            else{
                APIResult.Error("Error: ${response.code()} ${response.message()}")
            }
        }catch (e:Exception){
            APIResult.Error(e.localizedMessage?:"API Failed")
        }
    }
}