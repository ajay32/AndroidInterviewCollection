package com.example.interviewlist.codingquestions.arrayques


//Move all negative numbers to beginning and positive to end with constant extra space

// Approach -- if we sort the array negative will come at starting and positive at end

// Input: 3, 5, 6 ,-12, 11, -13, -5, 6, -7, 5, -3, -6, 4


fun sortNegativePosition(arr: Array<Int>) : Array<Int> {

    return arr.sortedArray()
}

fun main() {

    val sortedArray = sortNegativePosition(arrayOf(3, 5, 6 ,-12, 11, -13, -5, 6, -7, 5, -3, -6, 4))

    sortedArray.forEach { number -> println(number) }
}

