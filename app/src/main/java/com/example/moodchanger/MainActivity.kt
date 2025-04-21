package com.example.moodchanger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.moodchanger.ui.facescanner.FaceScannerScreen
import com.example.moodchanger.ui.model.MoodType
import com.example.moodchanger.ui.music.MoodMusicScreen
import com.example.moodchanger.ui.navigator.AppNavigation
import com.example.moodchanger.ui.theme.MoodChangerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MoodChangerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    AppNavigation()
//                    FaceScannerScreen

                    MoodMusicScreen(mood = MoodType.SAD, emptyList(), {}) { }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoodChangerTheme {
        Greeting("Android")
    }
}