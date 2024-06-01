package com.example.interviewlist.kotlin.codingquestions.stringques


//==================== adding stars to string at specfied position

//User
//Given a string str and an array of indices chars[] that describes the indices in the original string where the characters will be added. For this post, let the character to be inserted in star (*). Each star should be inserted before the character at the given index. Return the modified string after the stars have been added.
//
//Examples:
//
//Input: str = “geeksforgeeks”, chars = [1, 5, 7, 9]
//Output: g*eeks*fo*rg*eeks
//Explanation: The indices 1, 5, 7, and 9 correspond to the bold characters in “geeksforgeeks”.
//
//Input: str = “spacing”, chars = [0, 1, 2, 3, 4, 5, 6]
//Output: “*s*p*a*c*i*n*g”
fun addStarsToString(str: String, indices: IntArray): String {
    val sortedIndices = indices.sorted()
    val result = StringBuilder(str)

    // Insert stars in reverse order to avoid offsetting indices
    for (index in sortedIndices.reversed()) {
        result.insert(index, '*')
    }

    return result.toString()
}

fun main() {
    val str1 = "geeksforgeeks"
    val indices1 = intArrayOf(1, 5, 7, 9)
    println("Output: ${addStarsToString(str1, indices1)}")

    val str2 = "spacing"
    val indices2 = intArrayOf(0, 1, 2, 3, 4, 5, 6)
    println("Output: ${addStarsToString(str2, indices2)}")
}

