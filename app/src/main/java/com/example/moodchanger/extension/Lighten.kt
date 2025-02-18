package com.example.moodchanger.extension

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp

fun Color.lighten(percentage: Float): Color {
    return lerp(this, Color.White, percentage / 100f)
}