package com.example.moodchanger

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {
    mainq()
}

fun mainq(): Unit = runBlocking {

    val stateFlow = MutableStateFlow(0)
    stateFlow.value =1
    stateFlow.value = 2
    stateFlow.collect {
        println(it)
    }

}

fun getNumbersHotFlow(): MutableSharedFlow<Int> {
    val sharedFlow = MutableSharedFlow<Int>()
    GlobalScope.launch {
        for (i in 1..5) {
            delay(1000)
//            println("i $i")
            sharedFlow.emit(i)
        }
    }
    return sharedFlow
}