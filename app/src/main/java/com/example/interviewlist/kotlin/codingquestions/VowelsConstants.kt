package com.example.interviewlist.kotlin.codingquestions

// wehave to check for vowers and letter because there could be digits and sapces
fun findVowelsAndConstants(s:String) : Pair<Int, Int> {
    val vowels = "aeiou"
    var vowelsCount = 0
    var constantsCount = 0

    for (str in s) {
        if(str in vowels) {
            vowelsCount++
        } else if(str.isLetter()) {
            constantsCount++
        }
    }

   // return Pair<vowelsCount, constantsCount>() //we can not pass in brackets becuase its for defining type not for passing value
    return Pair(vowelsCount, constantsCount)
}

fun main() {

    val pairOfData = findVowelsAndConstants("Hello World")
    println("constants and vowers are $pairOfData")
}