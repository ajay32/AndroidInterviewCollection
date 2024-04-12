package com.example.interviewlist.codingquestions.stringques

//================== Rotate String clockwise and AntiClock wise =====================


fun leftRotate(str : String, k : Int) : String { "ekForGeeks Ge"

    val n = str.length
    val expectedK = k % n

    return str.substring(expectedK, n) + str.substring(0, expectedK)
}

fun rightRotate(str : String, k : Int) : String { "ksGeekForGee"

    val n = str.length
    val expectedK = k % n

    return str.substring( n - expectedK, n)  + str.substring(0, n - expectedK)
}


fun main() {
    val s1 = "GeekForGeeks"
    val k = 2

    println(leftRotate(s1, k))
    println(rightRotate(s1, k))
}

