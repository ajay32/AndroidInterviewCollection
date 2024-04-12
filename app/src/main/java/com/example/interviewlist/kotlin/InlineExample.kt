package com.example.interviewlist.kotlin

inline fun measureTime(action: () -> Unit) {
    action()
}

inline fun measureTime1(action: () -> Unit) {
    val startTime = System.nanoTime()
    action()
    val endTime = System.nanoTime()
    println("Total time taken to do other actions ${endTime - startTime} nano seconds")
}

fun main() {

    measureTime {
        println("Some other code executing")
    }

    measureTime1 {
        println("Some other code executing")
    }
}





