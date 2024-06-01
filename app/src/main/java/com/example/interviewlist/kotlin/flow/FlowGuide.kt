package com.example.interviewlist.kotlin.flow

//Kotlin's `Flow` is a type that represents an asynchronous stream of data. It's part of Kotlin's coroutines and is used for handling a sequence of data that gets emitted over time. Flow is particularly useful when dealing with reactive programming or streams where you need to handle data that can change over time, like user input, network responses, or database queries.
//
//### Understanding Kotlin Flow
//
//#### What is Flow?
//- **Asynchronous Stream**: Flow allows data to be emitted asynchronously and consumed in a non-blocking way.
//- **Cold Stream**: Unlike RxJava’s Observables, Flow is cold, meaning the code inside a Flow builder doesn't run until the flow is collected. This is similar to Sequences in Kotlin, where the code is not executed until you call functions like `toList()` or `forEach()`.
//
//#### Basic Components of Flow
//- **Flow Builder**: Used to define how the Flow emits items. Common builders include `flow { }`, `flowOf()`, and `channelFlow`.
//- **Operators**: Transformations you can apply to flows, such as `map`, `filter`, `take`, `reduce`, etc.
//- **Terminal Operators**: Used to collect the data from a Flow. Examples include `collect`, `toList`, `toSet`, etc.
//
//### Creating and Using Flows
//
//#### Creating a Flow
//Here’s how you can create a simple Flow that emits a sequence of numbers:
//
//```kotlin
//import kotlinx.coroutines.*
//import kotlinx.coroutines.flow.*
//
//fun numberFlow(): Flow<Int> = flow {
//    for (i in 1..5) {
//        delay(100)  // Simulate some computation or network delay
//        emit(i)
//    }
//}
//```
//
//#### Collecting a Flow
//To collect or consume the values from a Flow:
//
//```kotlin
//suspend fun collectNumbers() {
//    numberFlow().collect { value ->
//        println(value)
//    }
//}
//
//fun main() = runBlocking {
//    collectNumbers()
//}
//```
//
//#### Applying Operators
//Flow comes with a rich set of operators:
//
//```kotlin
//fun main() = runBlocking {
//    numberFlow()
//        .filter { it % 2 == 0 }  // Only even numbers
//        .map { it * it }         // Square them
//        .collect { println(it) }
//}
//```
//
//### Handling Flow Completion and Exceptions
//
//#### Completion
//You can handle the completion of a Flow using the `onCompletion` operator:
//
//```kotlin
//numberFlow()
//.onCompletion { cause ->
//    if (cause != null) println("Flow completed exceptionally")
//    else println("Flow completed successfully")
//}
//.collect { println(it) }
//```
//
//#### Exception Handling
//Use `catch` to handle exceptions in Flow:
//
//```kotlin
//numberFlow()
//.map { if (it == 3) throw RuntimeException("Error on $it") else it }
//.catch { e -> println("Caught $e") }
//.collect { println(it) }
//```
//
//### Real-world Use Cases
//- **Network Requests**: Fetch data from a network and handle it as it arrives.
//- **Database Streaming**: Stream database results as they become available.
//- **User Input**: React to user input in real-time.
//
//### Best Practices
//- **Thread Safety**: By default, Flow builders like `flow { }` are not confined to any specific thread. Use `flowOn` to specify the coroutine context.
//- **Combining Flows**: Use operators like `zip`, `combine` to work with multiple flows.
//- **Backpressure**: Manage backpressure (when a source emits faster than the collector can consume) using `buffer`, `conflate`, or `collectLatest`.
//
//### Conclusion
//Kotlin Flow is a powerful tool for managing asynchronous data streams in a reactive style, providing built-in support for backpressure and seamless integration with Kotlin’s coroutines. It is well-suited for building complex data transformation pipelines that can handle asynchronous updates elegantly. By understanding and utilizing Flow, you can significantly simplify the management of dynamic data in your applications.
//


//====================================================

//why we wrote catch or completion above collect ?

//In Kotlin's Flow API, the order in which you chain operators is significant and determines how they behave with respect to each other. The placement of `catch` and `onCompletion` operators before the `collect` operator isn't just a stylistic choice but is crucial for how errors and the completion signal are handled within the flow.
//
//### Handling Errors with `catch`
//
//The `catch` operator in Flow is used to intercept exceptions that are thrown from upstream flow operators or the flow emission itself. Placing `catch` before `collect` ensures that any exception that occurs in the flow emission or during any transformations (like `map`, `filter`, etc.) is caught before it reaches the terminal operation (`collect`).
//
//**Purpose:**
//- **Catching and handling errors:** If an error occurs anywhere upstream (before the catch), the `catch` operator will handle it, allowing for error processing or recovery without terminating the collection process abruptly.
//
//```kotlin
//flow {
//    emit(1)
//    emit(2)
//    throw RuntimeException("Something went wrong!")
//}
//.map { value ->
//    value * 2
//}
//.catch { e ->
//    println("Caught an exception: $e")
//}
//.collect { value ->
//    println(value)
//}
//```
//
//In this example, the exception thrown will be caught by the `catch` operator before it can terminate the flow, allowing the flow to handle the error gracefully, potentially continuing or completing without crashing.
//
//### Handling Completion with `onCompletion`
//
//The `onCompletion` operator is used to perform actions after the flow completes, either normally or due to an exception. It’s a kind of "finally" block for flows.
//
//**Purpose:**
//- **Resource cleanup and final actions:** It can be used for cleanup actions or to emit a final state. This operator gets called regardless of whether the flow completes successfully or exceptionally.
//
//```kotlin
//flow {
//    emit(1)
//    emit(2)
//}
//.onCompletion { cause ->
//    if (cause != null) println("Flow completed exceptionally")
//    else println("Flow completed successfully")
//}
//.collect { value ->
//    println(value)
//}
//```
//
//In this example, `onCompletion` will execute after all the emissions are collected and just before the flow collection completes, making it ideal for logging, cleanup, or updating the UI with a completion status.
//
//### Why Order Matters
//
//Placing `catch` and `onCompletion` **before** `collect` is essential because:
//- **Scope of error handling:** `catch` only catches exceptions from the upstream (before itself in the chain). If it were placed after `collect`, it wouldn't be able to intercept any exceptions because `collect` is a terminal operator and does not pass the flow further downstream.
//- **Completion signaling:** `onCompletion` needs to be before `collect` to ensure that any completion logic is applied as soon as the upstream flow operations complete and before any terminal actions or external side effects are triggered by `collect`.
//
//### Conclusion
//
//The placement of `catch` and `onCompletion` directly influences their effectiveness in handling errors and completions within a Flow. By using these operators judiciously before `collect`, you can ensure robust error handling and proper resource management in your reactive Kotlin applications.
//
//


//======================================

//example for backpressure, conflate, collectLatest
//
//In Kotlin's Flow API, managing backpressure is an important aspect of handling streams of data that produce items faster than they can be consumed. Flow provides several strategies to handle this scenario, such as `buffer`, `conflate`, and `collectLatest`. Each of these strategies has its use cases and behaves differently under pressure.
//
//### 1. **Buffer**
//
//The `buffer` operator allows the flow to run asynchronously by buffering emissions that are not yet collected. This is useful when you have a fast producer and want to prevent it from being blocked by a slower consumer. The buffer collects emitted values into a queue that the collector consumes from as it is able to.
//
//```kotlin
//import kotlinx.coroutines.*
//import kotlinx.coroutines.flow.*
//
//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        flow {
//            for (i in 1..5) {
//                delay(100)  // Simulate slow production
//                emit(i)
//            }
//        }
//            .buffer()  // Buffer emissions, do not suspend while waiting for collection
//            .collect { value ->
//                delay(300)  // Simulate slow consumption
//                println("Collected $value")
//            }
//    }
//    println("Collected in $time ms")
//}
//```
//
//Without the `buffer`, the total time would be the sum of production and consumption delays, but with `buffer`, production and consumption happen concurrently, reducing the overall time.
//
//### 2. **Conflate**
//
//The `conflate` operator skips intermediate values when the collector is too slow. Instead of maintaining all values like `buffer`, `conflate` will drop any values that are emitted while the collector is busy and will only process the most recent value available once the collector becomes ready.
//
//```kotlin
//import kotlinx.coroutines.*
//import kotlinx.coroutines.flow.*
//
//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        flow {
//            for (i in 1..5) {
//                emit(i)  // Fast emission without delay
//                delay(100)  // Make some delay
//            }
//        }
//            .conflate()  // Only the most recent value is delivered to the collector
//            .collect { value ->
//                delay(300)  // Slow consumption
//                println("Collected $value")
//            }
//    }
//    println("Collected in $time ms")
//}
//```
//
//In this example, you will notice that not all numbers are printed. Intermediate values are conflated (dropped), and only the latest values are collected whenever the collector is ready.
//
//### 3. **collectLatest**
//
//`collectLatest` is a terminal operator that cancels and restarts the collection of the flow whenever a new value is emitted. It ensures that the collector always deals with the most recent value and cancels the handling of any previous unfinished work.
//
//```kotlin
//import kotlinx.coroutines.*
//import kotlinx.coroutines.flow.*
//
//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        flow {
//            for (i in 1..5) {
//                emit(i)  // Fast emission
//                delay(100)  // Some delay between emissions
//            }
//        }
//            .collectLatest { value ->
//                println("Collecting $value")
//                delay(300)  // Simulate longer processing
//                println("Collected $value")
//            }
//    }
//    println("Collected in $time ms")
//}
//```
//
//In this code, only the last emitted value might be fully collected, as ongoing collections are cancelled when a new value arrives. This is useful when you only care about the latest data, and processing previous data is not necessary if newer data is available.
//
//### Summary
//
//Each of these techniques is used based on the specific requirements of your application:
//- **Buffer**: Use when you don't want to miss any data and can handle bursts of data efficiently.
//- **Conflate**: Use when you only need the latest data and can afford to lose intermediate values.
//- **collectLatest**: Use when processing time is significant, and only the latest data is relevant, allowing older processing tasks to be cancelled.
//
//
//

//Collecting 1
//Collecting 2
//Collecting 3
//Collecting 4
//Collecting 5
//Collected 5
//Collected in approximately 500 ms
