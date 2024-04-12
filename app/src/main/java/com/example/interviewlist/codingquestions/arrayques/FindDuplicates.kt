package com.example.interviewlist.codingquestions.arrayques

// Count duplicate characters in a string Hello world (duplicate are greater than 1 value)
// I will return map it will give char wth the counts greater than 1

fun findTheDuplicatesInAString(s: String): Map<Char, Int> {

    // val duplicateCount = s.lowercase().groupingBy {it}.eachCount().filter {it.value > 1}
    val map = mutableMapOf<Char, Int>()

    for(char in s) {
        var count = map.getOrDefault(char, 0)
        map[char] = count + 1
    }

    return map.filter { it.value > 1}
}

fun main() {
    println(findTheDuplicatesInAString("Hhello World"))
}



