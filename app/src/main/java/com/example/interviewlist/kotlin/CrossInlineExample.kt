package com.example.interviewlist.kotlin

// CrossInline -> lambda parameters that are not allowed to return from the enclosing function.

inline fun performingTask(crossinline task: () -> Unit) {
    task()
}

inline fun runInBackground(crossinline task: () -> Unit) {
    Thread {
        task()
    }.start()
}


fun main() {
    performingTask {
        println("Performing some task")
        // `return` would not be allowed here because `task` is marked with `crossinline`
    }

    runInBackground {
        println("This runs in a background thread.")
        // `return` would not be allowed here because `task` is marked with `crossinline`
    }
}
