package com.example.moodchanger.data.model

data class SongResponse(
    val success: Boolean,
    val data: SongData
)

data class SongData(
    val total: Int,
    val start: Int,
    val results: List<Song>
)

data class Song(
    val id: String,
    val name: String,
    val type: String,
    val year: String,
    val releaseDate: String?,
    val duration: Int,
    val label: String,
    val explicitContent: Boolean,
    val playCount: Int,
    val language: String,
    val hasLyrics: Boolean,
    val lyricsId: String?,
    val url: String,
    val copyright: String,
    val album: Album,
    val artists: Artists,
    val image: List<Image>,
    val downloadUrl: List<DownloadUrl>
)

data class Album(
    val id: String,
    val name: String,
    val url: String
)

data class Artists(
    val primary: List<Artist>,
    val featured: List<Any>,
    val all: List<Artist>
)

data class Artist(
    val id: String,
    val name: String,
    val role: String,
    val image: List<Image>,
    val type: String,
    val url: String
)

data class Image(
    val quality: String,
    val url: String
)

data class DownloadUrl(
    val quality: String,
    val url: String
)
