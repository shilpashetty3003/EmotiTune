package com.example.moodchanger.ui.music

import androidx.lifecycle.ViewModel
import com.example.moodchanger.data.repository.SongsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SongViewModel @Inject constructor(private val repository: SongsRepository) :ViewModel(){

}