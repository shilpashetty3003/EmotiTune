package com.example.moodchanger.ui.model

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class MoodTheme(
    val title: String,
    val backgroundBrush: Brush,
    val textColor: Color,
    val animation: Int? = null
)