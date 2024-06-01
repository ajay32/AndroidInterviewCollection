package com.example.interviewlist.kotlin.coroutines

//Structured concurrency is a concept in Kotlin coroutines that ensures proper management and containment of concurrency within a well-defined structure of execution.
//
//Principles of Structured Concurrency
//Structured concurrency revolves around a few key principles:
//
//Lifecycle Management: Every coroutine is launched within a specific CoroutineScope, which controls the lifecycle of the coroutines it contains. This means that when the scope is terminated (either through completion or cancellation), all coroutines launched within that scope are also automatically cancelled.
//Parent-Child Relationship: In structured concurrency, coroutines have a parent-child relationship where the parent coroutine waits for all its child coroutines to complete before it completes itself. This ensures that no tasks are left hanging, and all operations are accounted for before moving on.
//Error Propagation: Errors or exceptions thrown in child coroutines are propagated up to their parent coroutine. This simplifies error handling as you only need to handle exceptions at a higher level rather than within each coroutine.
//
//fun main() = runBlocking { // This: CoroutineScope
//    launch {
//        // Launch a new coroutine in the scope of runBlocking
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello")
//}
//
//In this example, runBlocking creates a CoroutineScope and does not complete until all the coroutines launched within it are complete. The launch function creates a new coroutine that is a child of the coroutine defined by runBlocking. This means the "World!" message will only be printed after a delay of 1 second, and the runBlocking will wait for the launch coroutine to complete before it allows the program to finish.
//
//Benefits of Structured Concurrency
//Automatic Cleanup: Since coroutines are bound to their scope, they are automatically cancelled if the scope is destroyed. This is particularly useful in Android development, where coroutines can be tied to the lifecycle of activities or fragments to prevent memory leaks.
//Simplified Error Handling: Errors in a child coroutine can automatically propagate to the parent, allowing for centralized error handling without cluttering the code with try-catch blocks everywhere.
//Predictable Behavior: Structured concurrency makes the behavior of concurrent code more predictable and easier to reason about, as you know exactly when coroutines start and finish relative to their scope.
//
//
//Structured concurrency is a concept in Kotlin coroutines that ensures proper management and containment of concurrency within a well-defined structure of execution. It aims to simplify concurrent code and make it safer by tying the lifecycle of coroutines to the scope in which they are launched. This approach prevents common issues such as leaks, dangling operations, and unexpected behavior due to unfinished coroutines.
//
//Principles of Structured Concurrency
//Structured concurrency revolves around a few key principles:
//
//Lifecycle Management: Every coroutine is launched within a specific CoroutineScope, which controls the lifecycle of the coroutines it contains. This means that when the scope is terminated (either through completion or cancellation), all coroutines launched within that scope are also automatically cancelled.
//Parent-Child Relationship: In structured concurrency, coroutines have a parent-child relationship where the parent coroutine waits for all its child coroutines to complete before it completes itself. This ensures that no tasks are left hanging, and all operations are accounted for before moving on.
//Error Propagation: Errors or exceptions thrown in child coroutines are propagated up to their parent coroutine. This simplifies error handling as you only need to handle exceptions at a higher level rather than within each coroutine.
//How It Works in Kotlin
//In Kotlin, structured concurrency is implemented using CoroutineScope and its associated builders (launch, async, etc.). Here’s a basic example of how structured concurrency can be used:
//
//kotlin
//Copy code
//fun main() = runBlocking { // This: CoroutineScope
//    launch {
//        // Launch a new coroutine in the scope of runBlocking
//        delay(1000L)
//        println("World!")
//    }
//    println("Hello")
//}
//In this example, runBlocking creates a CoroutineScope and does not complete until all the coroutines launched within it are complete. The launch function creates a new coroutine that is a child of the coroutine defined by runBlocking. This means the "World!" message will only be printed after a delay of 1 second, and the runBlocking will wait for the launch coroutine to complete before it allows the program to finish.
//
//Benefits of Structured Concurrency
//Automatic Cleanup: Since coroutines are bound to their scope, they are automatically cancelled if the scope is destroyed. This is particularly useful in Android development, where coroutines can be tied to the lifecycle of activities or fragments to prevent memory leaks.
//Simplified Error Handling: Errors in a child coroutine can automatically propagate to the parent, allowing for centralized error handling without cluttering the code with try-catch blocks everywhere.
//Predictable Behavior: Structured concurrency makes the behavior of concurrent code more predictable and easier to reason about, as you know exactly when coroutines start and finish relative to their scope.
//
//
//Practical Example: Android ViewModel
//In Android development, you can use structured concurrency in a ViewModel to automatically cancel all running coroutines when the ViewModel is cleared, preventing operations from running on a view that is no longer visible or existing.
//
//class MyViewModel : ViewModel() {
//    private val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())
//
//    fun loadData() {
//        viewModelScope.launch {
//            // Perform network operations or database queries
//        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        viewModelScope.cancel() // Cancel all coroutines when ViewModel is cleared
//    }
//}
//
//In this example, viewModelScope is used to launch coroutines for data loading. When the ViewModel is destroyed (e.g., when the associated UI component is destroyed), onCleared() is called, and all coroutines in viewModelScope are cancelled.
//
//Structured concurrency ensures that coroutines are an integral part of the application structure, making concurrent operations safer and easier to manage. This approach is fundamental in Kotlin for building reliable and robust concurrent applications.
//
//
//In the context of using viewModelScope in Android's ViewModel, you actually don't need to explicitly call viewModelScope.cancel() in the onCleared() method. The reason for this is that viewModelScope is automatically tied to the lifecycle of the ViewModel. When the ViewModel is cleared, and hence on the brink of being destroyed, viewModelScope automatically cancels all running coroutines started within that scope.
//
//u dont need it but you can
//class MyViewModel : ViewModel() {
//    private val customScope = CoroutineScope(Job() + Dispatchers.Main)
//
//    override fun onCleared() {
//        super.onCleared()
//        customScope.cancel() // Needed to prevent memory leaks
//    }
//}

//=========================

// In this examPLE WE have not define any exception handler in launch .. so it propgater to scope and we have handler in scope to handle exception

//val handler = CoroutineExceptionHandler { _, exception ->
//    println("Caught in handler: ${exception.localizedMessage}")
//}
//
//val scope = CoroutineScope(Job() + handler)
//
//scope.launch {
//    throw Exception("Failed coroutine")
//}
//

//================

//import kotlinx.coroutines.*
//
//fun main() = runBlocking {
//    val job = launch {
//        val child = launch {
//            try {
//                println("Child coroutine is running")
//                throw ArithmeticException("Something went wrong!")
//            } catch (e: Exception) {
//                println("Caught an exception: ${e.message}")
//            }
//        }
//        try {
//            child.join()
//            println("Parent continues after child")
//        } catch (e: CancellationException) {
//            println("Parent was cancelled due to child failure")
//        }
//    }
//    job.join()
//}
//
//
////========
//
//import kotlinx.coroutines.*
//
//fun main() = runBlocking {
//    val job = launch {
//        val child = launch {
//            try {
//                println("Child coroutine is running")
//                throw ArithmeticException("Something went wrong!")
//            } catch (e: Exception) {
//                println("Caught an exception: ${e.message}")
//            }
//        }
//        try {
//            child.join()
//            println("Parent continues after child")
//        } catch (e: CancellationException) {
//            println("Parent was cancelled due to child failure")
//        }
//    }
//    job.join()
//}
//
//
//
//Let's break down and explain the provided Kotlin coroutine code, focusing on its structure, flow, and exception handling:
//
//### Code Structure and Flow
//
//1. **Outer Coroutine (Parent Coroutine)**
//- The program starts with `runBlocking`, which creates a blocking coroutine scope. This means it blocks the current thread until all the coroutines within its scope are completed. It is often used to bridge regular blocking code to libraries that are written in a suspending style, allowing main threads to wait until the coroutine completes.
//
//2. **Nested Coroutine (Child Coroutine)**
//- Inside `runBlocking`, a `launch` block initiates a parent coroutine. Within this parent coroutine, another `launch` block initiates a child coroutine.
//
//### Detailed Execution Flow
//
//- **Child Coroutine Execution**:
//- The child coroutine starts execution and prints "Child coroutine is running".
//- It then throws an `ArithmeticException` with the message "Something went wrong!".
//- This exception is caught by the `try-catch` block within the child coroutine itself, which handles the exception and prints "Caught an exception: Something went wrong!".
//
//- **Parent Coroutine Monitoring Child**:
//- After launching the child coroutine, the parent coroutine calls `child.join()`, which means the parent coroutine will suspend until the child coroutine completes (either normally or due to an exception).
//- Since the child coroutine completes successfully (its exception is handled internally), the parent coroutine resumes execution.
//- The parent coroutine then prints "Parent continues after child". This line indicates that the parent coroutine was not cancelled and continues execution normally after the child has completed.
//
//- **Job Completion**:
//- The parent coroutine reaches its end, and `runBlocking` also completes as there are no more coroutines running.
//- `job.join()` in `runBlocking` ensures that the script waits until the parent coroutine (job) is fully completed before finishing the main function.
//
//### Exception Handling
//
//- **Within the Child Coroutine**:
//- The `try-catch` block inside the child coroutine effectively handles the `ArithmeticException`, preventing it from propagating to the parent coroutine. Thus, the child's failure does not affect the parent directly.
//
//- **Within the Parent Coroutine**:
//- The parent coroutine includes a `try-catch` block around `child.join()`, prepared to catch a `CancellationException`. However, because the child coroutine handles its exception internally and does not fail in a way that cancels itself, no `CancellationException` is thrown, and the parent does not enter its catch block.
//
//### Summary
//
//This code exemplifies structured concurrency where coroutines are organized hierarchically, and exception handling is localized to manage specific failures gracefully. The child coroutine handles its own exceptions without affecting the parent coroutine, showcasing the encapsulation and independent management of failures in nested coroutines. This structure ensures that the application can handle errors robustly without unnecessary propagation of exceptions or unintended cancellations of parent coroutines.


// Exception handling with async =================================

//import kotlinx.coroutines.*
//
//fun main() = runBlocking {
//    val deferredResult = async {
//        // Simulate network request or some other operation that might fail
//        if (Random.nextBoolean()) { // Randomly throws an exception
//            throw IOException("Failed to load data")
//        }
//        "Data loaded successfully"
//    }
//
//    try {
//        val result = deferredResult.await()  // This is where the exception gets thrown if the operation failed
//        println(result)
//    } catch (e: IOException) {
//        println("Caught an exception: ${e.message}")
//    }
//}
//
//
////=============================================
//
//fun main() = runBlocking {
//    val dataLoader1 = async {
//        loadDataFromNetwork("https://example.com/data1")
//    }
//    val dataLoader2 = async {
//        loadDataFromNetwork("https://example.com/data2")
//    }
//
//    try {
//        val result1 = dataLoader1.await()
//        println("Data 1 loaded: $result1")
//    } catch (e: Exception) {
//        println("Failed to load data 1: ${e.message}")
//    }
//
//    try {
//        val result2 = dataLoader2.await()
//        println("Data 2 loaded: $result2")
//    } catch (e: Exception) {
//        println("Failed to load data 2: ${e.message}")
//    }
//}
//
//suspend fun loadDataFromNetwork(url: String): String {
//    // Simulate network request
//    throw Exception("Network error")
//}
//
//
////============================
//
//import kotlinx.coroutines.*
//import kotlinx.coroutines.async
//
//fun main() = runBlocking {
//    val deferred1 = async {
//        "Result of Task 1"
//    }
//    val deferred2 = async {
//        throw Exception("Failed on Task 2")
//    }
//    val deferred3 = async {
//        "Result of Task 3"
//    }
//
//    val results = listOf(deferred1, deferred2, deferred3)
//    results.forEach { deferred ->
//        try {
//            println("Result: ${deferred.await()}")
//        } catch (e: Exception) {
//            println("Error: ${e.message}")
//        }
//    }
//}

//=================================

//In Kotlin coroutines, handling exceptions in a hierarchy involving `async` builders and a `CoroutineExceptionHandler` can be somewhat nuanced due to how exception propagation works in structured concurrency. Here's an explanation and example to clarify how exceptions can be managed within a parent-child relationship using `async` and a `CoroutineExceptionHandler`.
//
//### Understanding Exception Propagation in `async`
//
//1. **Exception Capture**: Unlike `launch`, where exceptions are immediately propagated to the parent coroutine, `async` captures any exceptions that occur and stores them until the result is explicitly requested with `await()`. If the exception is not handled at the time of calling `await()`, it will be thrown at that point.
//
//2. **CoroutineExceptionHandler Usage**: `CoroutineExceptionHandler` is typically used with `launch` because `launch` doesn't return a result to be handled directly, and thus, any uncaught exceptions are handled by the exception handler. In the case of `async`, the `CoroutineExceptionHandler` will not catch exceptions thrown from `await()` because these exceptions are considered to be handled by the caller of `await()`.
//
//### Example: Parent-Child Relationship with `async` and Exception Handling
//
//Here’s an example that demonstrates handling exceptions in a parent-child relationship using `async` and a `CoroutineExceptionHandler`.
//
//```kotlin
//import kotlinx.coroutines.*
//
//fun main() = runBlocking {
//    val handler = CoroutineExceptionHandler { _, exception ->
//        println("Caught by CoroutineExceptionHandler: ${exception.localizedMessage}")
//    }
//
//    val parentJob = launch(handler) { // Applying the handler at the parent level
//        val childJob = async {
//            println("Child coroutine doing work")
//            throw ArithmeticException("Something went wrong in child")
//        }
//
//        try {
//            println("Parent coroutine continues")
//            childJob.await() // Attempt to await child's result
//            println("This line will not execute if child fails")
//        } catch (e: Exception) {
//            println("Caught in parent: ${e.localizedMessage}")
//        }
//    }
//
//    parentJob.join()
//    println("Parent coroutine has completed")
//}
//```
//
//
//
//### Breakdown of the Code
//
//1. **CoroutineExceptionHandler Setup**: A `CoroutineExceptionHandler` is set up to handle exceptions not caught within the coroutine scope. However, in this structure, the handler will not catch exceptions from `await()` as those are expected to be managed by the code that calls `await()`.
//
//2. **Parent and Child Relationship**:
//- The parent coroutine uses `launch` with an attached `CoroutineExceptionHandler`.
//- The child coroutine uses `async` and throws an exception.
//
//3. **Exception Handling**:
//- The exception in the child coroutine (`async`) is thrown during the work but is captured and stored by `async` until `await()` is called.
//- When `parentJob` calls `await()` on `childJob`, it rethrows the captured exception, which is then caught by the surrounding `try-catch` block in the parent coroutine.
//
//4. **CoroutineExceptionHandler Role**: In this setup, the `CoroutineExceptionHandler` will only catch unhandled exceptions from the `launch` coroutine body, not the ones rethrown by `await()`. This demonstrates that `CoroutineExceptionHandler` is not invoked for exceptions that are considered handled by the coroutine's code, specifically the exceptions that are thrown and caught around `await()` calls.
//
//### Conclusion
//
//In structured concurrency, especially when using `async`, it is crucial to manage exceptions where the coroutine's results are consumed (`await()`). `CoroutineExceptionHandler` provides a safety net for uncaught exceptions in coroutines launched with `launch`. However, in the case of `async`, handling exceptions directly around the `await()` call is necessary to manage the errors effectively. This arrangement ensures that all parts of the coroutine hierarchy can handle their exceptions appropriately or escalate them as needed.
//
//


//===================================================
//SupervisorJob can be used in a coroutine scope to prevent exceptions in one child coroutine from canceling other siblings. This allows individual error handling without affecting other operations.
//
//
//import kotlinx.coroutines.*
//
//fun main() = runBlocking {
//    val supervisor = SupervisorJob()
//    val scope = CoroutineScope(coroutineContext + supervisor)
//
//    val deferred1 = scope.async {
//        throw Exception("Something went wrong")
//    }
//
//    val deferred2 = scope.async {
//        delay(500)
//        "I am fine"
//    }
//
//    runCatching {
//        deferred1.await()
//    }.onFailure { println("deferred1 failed: ${it.message}") }
//
//    println("deferred2 says: ${deferred2.await()}")
//}


//=========================

//Encapsulating Error Handling in a Wrapper Function
//
//Create a wrapper function that internally uses try-catch and can return a result that encapsulates both successful results and errors. This is similar to using Either, Result, or Try types in functional programming.
//
//import kotlinx.coroutines.*
//
//fun <T> CoroutineScope.safeAsync(block: suspend () -> T): Deferred<Result<T>> = async {
//    try {
//        Result.success(block())
//    } catch (e: Throwable) {
//        Result.failure(e)
//    }
//}
//
//fun main() = runBlocking {
//    val deferred = safeAsync {
//        if (Random.nextBoolean()) {
//            throw Exception("Failed!")
//        }
//        "Success"
//    }
//
//    val result = deferred.await()
//    result.onSuccess { value ->
//        println(value)
//    }.onFailure { error ->
//        println("Error occurred: ${error.message}")
//    }
//}


//====================================

