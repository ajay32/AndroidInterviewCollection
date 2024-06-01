package com.example.interviewlist.kotlin.logic_questions

class NetworkCall {
    fun execute(): Status = Status.SUCCESS
}

class Log {
    fun logError(status: Status) {
        println("Error occurred: $status")
    }
}

enum class Status { SUCCESS, ERROR }

fun makeNetworkCall(log: Log): Status {
    val networkCall = NetworkCall()
    return networkCall.execute().also { status ->
        if (status == Status.ERROR) {
            log.logError(status)
        }
    }
}

//Question: What is returned by the makeNetworkCall function when the network call is successful, and what is logged?

//Conclusion:
//When the makeNetworkCall function is called with a successful network call (status = Status.SUCCESS):
//
//The function returns Status.SUCCESS.
//Nothing is logged because the error logging condition is not met.
//This setup ensures that error logging only occurs when there is an actual error (Status.ERROR), maintaining clear and purposeful log outputs.
//