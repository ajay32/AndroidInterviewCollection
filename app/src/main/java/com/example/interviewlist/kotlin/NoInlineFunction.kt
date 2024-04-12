package com.example.interviewlist.kotlin

//In this example, performOperation takes two lambda expressions, but only operation is inlined.
// The printResult lambda, marked with noinline, is not inlined, which means it can be passed around or invoked later,

//inline ka matlab kya hota hai -> yahi ki app bytecode copy karte ho same method mai yaha se inline fun call kar rhe ho
// ok so now noinline means hum us fun ka byte code copy nai karenge ..us se as it is rakhenge (Store karnege)
// taaki use or functions main pass kare.. taaki or func se call ho paaye

//such as wanting to pass the lambda as an argument to another function that does not accept inlined lambdas, or wanting to store it for later use.

//Problem Statement: You need a function that accepts a lambda to perform some UI operation, and a second lambda for logging or handling the operation result. However, the logging function needs to be passed around to other components or stored for execution at a later stage, like after a network call or another asynchronous operation completes.

inline fun performOperation(noinline printResult: () -> Unit, operation: () -> Unit) {
    operation()
    println("Operation performed. Result:")
    printResult()
}

fun main() {
    performOperation({ println("Result printed.") }) {
        println("Performing operation...")
    }
}


// noinline example



//inline fun performSomeOperation(noinline logger: (String) -> Unit, action: (String) -> Unit) {
//    action("Do not talk") // Corrected "Do not tak" to "Do not talk"
//    println("Action is completed.")
//    logger("My deal is so-so.") // Assuming "My dil is su o su" should be "My deal is so-so."
//}
//
//fun main() {
//    // This lambda handles logging.
//    val logger: (String) -> Unit = { result ->
//        println("Data is logging: $result")
//    }
//
//    // This lambda handles some action.
//    val someAction: (String) -> Unit = { result ->
//        println("Some action is done with $result")
//    }
//
//    performSomeOperation(logger, someAction)
//}


