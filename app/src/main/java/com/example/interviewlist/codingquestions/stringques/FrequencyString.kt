package com.example.interviewlist.codingquestions.stringques

//============================ Print Frequnency String


fun printFrequencies(str : String) : String { // "aabccccddd" in sorted order a2b1c4d3

    val strMap = mutableMapOf<Char, Int>()

    for(char in str) {
        strMap[char] = strMap.getOrDefault(char, 0) + 1
    }

    // sort the map
    val sortedMap = strMap.toSortedMap()

    val frequencyString = StringBuffer()

    for((char, count) in sortedMap) {
        frequencyString.append("$char$count")
    }


    return frequencyString.toString()
}


fun main() {

    println(printFrequencies("aabccccddd"))

    val input2 = "geeksforgeeks"
    println("Input: $input2\nOutput: ${printFrequencies(input2)}")

}