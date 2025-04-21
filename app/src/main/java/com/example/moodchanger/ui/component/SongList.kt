package com.example.moodchanger.ui.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.moodchanger.data.model.Song

@Composable
fun SongList(songs: List<Song>, textColor: Color, onPlay: (Song) -> Unit) {
    LazyColumn(modifier = Modifier.weight(1f)) {
        items(songs) { song ->
            SongItem(song = song, textColor = textColor, onClick = onPlay)
        }
    }
}