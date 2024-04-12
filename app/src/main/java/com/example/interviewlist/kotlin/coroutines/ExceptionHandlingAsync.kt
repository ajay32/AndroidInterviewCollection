package com.example.interviewlist.kotlin.coroutines


//================== Handling excpetion with async

// it will handle the exption but show u the exception in the logs for you to look into it

import kotlinx.coroutines.*

fun main() = runBlocking {


    val deffered = async {
        // here it is going to throw an error
        throw Exception("Hey")
    }

    try {
        deffered.await()
    } catch(e: Exception) {
        print("I got the excecption ${e.message}")
    }

}