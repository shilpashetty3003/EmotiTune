package com.example.moodchanger.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moodchanger.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navComposable: NavController) {

    LaunchedEffect(Unit) {
        delay(1500)
        navComposable.navigate("home") {
            popUpTo("splash") {
                inclusive = true
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.light_purple))
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_dumbstics),
            contentDescription = "Top Right Image",
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.TopEnd)
                .size(100.dp)
        )

        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_music),
                contentDescription = "Top Right Image",
                Modifier.size(width = 120.dp, height = 50.dp)
            )

            Text(
                text = "Moody Music",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
            )
        }


        Image(
            painter = painterResource(id = R.drawable.ic_guitar),
            contentDescription = "Bottom Left Image",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 40.dp)
                .size(100.dp)
        )
    }
}


@Preview
@Composable
fun previewSplashScreen() {

    SplashScreen(navComposable = rememberNavController())
}