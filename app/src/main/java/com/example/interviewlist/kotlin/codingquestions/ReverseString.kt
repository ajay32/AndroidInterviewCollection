package com.example.interviewlist.kotlin.codingquestions

//fun reverseAString(s: String) : String{
//    return s.reversed()
//}
//
//fun main() {
//    val reverseString = reverseAString("Ajay")
//    println(reverseString)
//}


//========= reverse a string without reversed method

fun reverseAString(s: String) : String {

    var reverseString = ""
    for (i in s.indices) {
        println(s[i])
        reverseString = s[i] + reverseString
    }
    return reverseString
}

fun main() {
    val reverseString = reverseAString("AJay")
    println(reverseString)
}