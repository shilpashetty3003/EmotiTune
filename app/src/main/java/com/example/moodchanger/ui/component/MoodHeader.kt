package com.example.moodchanger.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.moodchanger.R
import com.example.moodchanger.ui.model.MoodTheme

@Composable
fun MoodHeader(theme: MoodTheme) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.ic_music),
            contentDescription = null,
            tint = theme.textColor
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = theme.title,
            style = MaterialTheme.typography.headlineMedium,
            color = theme.textColor
        )
    }
}

@Composable
fun SwitchMoodButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,

    ) {
        Text("Switch Mood 🎵")
    }
}

@Composable
fun UpliftQuote(text: String, textColor: Color) {
    Card(
        colors = CardDefaults.cardColors(containerColor = textColor.copy(alpha = 0.1f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(12.dp)
        )
    }
}
