package com.example.moodchanger

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MoodApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}