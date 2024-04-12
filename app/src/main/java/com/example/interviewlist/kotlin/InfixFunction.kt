package com.example.interviewlist.kotlin



//Readibility
// use infix function for redability .. you can remove . (dot) and paranthesis from the function
// to make extension function more redable you can create infix funtion


fun main() {

    // lets try or function is a infix fun
    val a = true
    val b = true

    val result = a.or(b) // return true if any of the value is true    or a || b
    println(result)

    val result1 = a or b  // infix way
    println(result1)

    //==================

    println(10.add(20))
    println(10 add1 20)

}


// lets create my own infix function
// create extension fun for Int



fun Int.add(b: Int) = this + b  // this here represent Int before it
infix fun Int.add1(b: Int) = this + b

