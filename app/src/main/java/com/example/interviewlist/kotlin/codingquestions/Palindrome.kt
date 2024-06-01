package com.example.interviewlist.kotlin.codingquestions


fun findPalindromw(s: String) : Boolean {

    return s == s.reversed()
}

fun main() {

    val plaindromVal = findPalindromw("racecar") //forward
    println(plaindromVal)
}