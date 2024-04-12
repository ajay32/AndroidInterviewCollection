package com.example.interviewlist.kotlin

//=====================================
// filter and map with list

fun main() {
    val numbers = listOf(1,2,3,4,5,10,20,40,50)

    val filteredNumber = numbers.filter { it > 10}

    val squareNumbers = numbers.map {it * it}

    println("numbers ${numbers}")
    println("filteredNumber ${filteredNumber}")
    println("squareNumbers ${squareNumbers}")

}