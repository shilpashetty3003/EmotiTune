package com.example.moodchanger.ui.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moodchanger.ui.home.HomeScreen
import com.example.moodchanger.ui.splash.SplashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash"){
        composable("splash") {
            SplashScreen(navController)
        }
        composable("home"){
            HomeScreen()
        }
    }
}