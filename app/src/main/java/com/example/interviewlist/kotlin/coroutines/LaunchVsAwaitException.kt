package com.example.interviewlist.kotlin.coroutines

//Using async and await
//The async coroutine builder is used for coroutines that produce a result and need to handle exceptions when the result is consumed using await. Exceptions are caught when the await method is called, not at the point where the exception occurs.
//
//val deferred = GlobalScope.async {
//    riskyNetworkCall()  // Might throw an exception
//}
//try {
//    val result = deferred.await()
//    updateUI(result)
//} catch (e: Exception) {
//    handleError(e)
//}
//
//
//In this example, exceptions thrown by riskyNetworkCall are caught within the coroutine. If the exception were not caught, it would lead to an unhandled exception.
//
//GlobalScope.launch {
//    try {
//        val data = riskyNetworkCall()
//        updateUI(data)
//    } catch (e: Exception) {
//        handleError(e)
//    }
//}
//
//suspend fun riskyNetworkCall(): String {
//    // Might throw IOException
//}
