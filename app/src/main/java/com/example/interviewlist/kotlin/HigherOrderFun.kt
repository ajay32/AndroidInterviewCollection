package com.example.interviewlist.kotlin




// lets create
// A fun returns a higher order fun
fun returnsName(language: String) : (String) -> String {
    return when(language) {
        "English" -> { name -> "Hello $name"}
        "Spanish" -> {name -> "Hola $name"}
        else -> {name -> "Hi $name"}
    }

}

fun main() {
    val greeting = returnsName("English")
    val greeting2 = returnsName("Spanish")

    println(greeting("Ajay"))
    println(greeting("Rahul"))

    //=============================

    val twoIntValue  = calculateTwoInt(5, 10)  {a, b -> a+b}
    println(twoIntValue)
}


// Higher order function can take a function and return Int value

fun calculateTwoInt(a: Int, b: Int, operation: (Int, Int) -> Int) : Int {
    return operation(a, b)
}




