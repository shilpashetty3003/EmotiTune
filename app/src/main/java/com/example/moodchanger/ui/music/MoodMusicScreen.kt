package com.example.moodchanger.ui.music

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
//import com.airbnb.lottie.compose.LottieAnimation
//import com.airbnb.lottie.compose.LottieCompositionSpec
//import com.airbnb.lottie.compose.LottieConstants
//import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.moodchanger.R
import com.example.moodchanger.data.model.Song
import com.example.moodchanger.ui.component.MoodHeader
import com.example.moodchanger.ui.component.SongList
import com.example.moodchanger.ui.component.SwitchMoodButton
import com.example.moodchanger.ui.component.UpliftQuote
import com.example.moodchanger.ui.model.MoodTheme
import com.example.moodchanger.ui.model.MoodType

@Composable
fun MoodMusicScreen(
    mood: MoodType,
    songs: List<Song>,
    onPlay: (Song) -> Unit,
    onSwitchMoodClick: () -> Unit
) {
    val theme = getMoodTheme(mood)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(theme.backgroundBrush)
            .padding(16.dp)
    ) {
        Column {
            MoodHeader(theme)

            if (mood in listOf(MoodType.SAD, MoodType.ANGRY, MoodType.LOW)) {
                UpliftQuote(text = getUpliftMessage(mood), textColor = theme.textColor)
                Spacer(Modifier.height(12.dp))
            }

            SongListHeader(theme.textColor)

            SongList(songs, theme.textColor, onPlay)

            Spacer(Modifier.height(16.dp))

            SwitchMoodButton(onSwitchMoodClick)
        }

        theme.animation?.let {
//            LottieAnimation(
//                composition = rememberLottieComposition(LottieCompositionSpec.RawRes(it)).value,
//                iterations = LottieConstants.IterateForever,
//                modifier = Modifier.size(100.dp)
//                    .align(Alignment.TopEnd)
//            )
        }
    }
}

@Composable
fun SongListHeader(textColor: Color) {
    Text(
        text = "Your Personalized Mix",
        style = MaterialTheme.typography.titleLarge,
        color = textColor
    )
    Spacer(Modifier.height(8.dp))
}

fun getUpliftMessage(mood: MoodType): String {
    return when (mood) {
        MoodType.SAD -> "It’s okay to feel sad sometimes. Let music lift you. 💙"
        MoodType.ANGRY -> "Take a deep breath. Let rhythm calm your fire. 🔥"
        MoodType.LOW -> "You’re not alone. Music’s here to guide you back. 🌤"
        else -> ""
    }
}


fun getMoodTheme(mood: MoodType): MoodTheme {
    return when (mood) {
        MoodType.HAPPY -> MoodTheme(
            title = "Feeling Happy 😊",
            backgroundBrush = Brush.verticalGradient(listOf(Color(0xFFFFE57F), Color(0xFFFFC107))),
            textColor = Color(0xFF1B5E20),
            animation = R.raw.happy_music_anim
        )

        MoodType.SAD -> MoodTheme(
            title = "Feeling Blue 💧",
            backgroundBrush = Brush.verticalGradient(listOf(Color(0xFF90A4AE), Color(0xFF607D8B))),
            textColor = Color.White,
            animation = R.raw.sad_wave_anim
        )

        MoodType.ANGRY -> MoodTheme(
            title = "Feeling Intense 🔥",
            backgroundBrush = Brush.verticalGradient(listOf(Color(0xFFFF8A65), Color(0xFFD84315))),
            textColor = Color.White,
            animation = R.raw.fire_anim
        )

        MoodType.LOW -> MoodTheme(
            title = "Feeling Low ☁️",
            backgroundBrush = Brush.verticalGradient(listOf(Color(0xFFB0BEC5), Color(0xFF78909C))),
            textColor = Color.White,
            animation = R.raw.happy_music_anim
        )
    }
}
