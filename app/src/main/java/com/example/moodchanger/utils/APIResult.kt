package com.example.moodchanger.utils

sealed class APIResult<out T> {
    data class Success<out T>(val data:T) :APIResult<T>()
    data class Error(val message:String):APIResult<Nothing>()
    object Loading: APIResult<Nothing>()

}