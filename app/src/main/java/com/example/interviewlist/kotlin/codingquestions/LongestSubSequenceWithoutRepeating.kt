package com.example.interviewlist.kotlin.codingquestions

//find the longest substring without repeating in the string in kotlin .. using set and two pointer approach with sliding window
//https://www.youtube.com/watch?v=jHj13UHURr8 to understand sliding window concept

fun findLongestSubsequence(s: String) : Int {

    var left =0  // pointer1
    var right = 0 // pointer2
    var maxLength = 0 // windows length
    var seen = mutableSetOf<Char>()

    while(right < s.length) {

        var currentElement = s[right]

        if(!seen.contains(currentElement)) { //we are good to go to add that element in set
            seen.add(currentElement)
            maxLength = maxOf(maxLength, right - left + 1)    // first element //a   0-0 + 1
            right++ //moving to next position

        } else {
            seen.remove(s[left])
            left++ // closing the widow from left by each position

        }

    }



    return maxLength
}

fun main() {

    val input1 = "abcabcbb"
    val input2 = "bbbbb"
    val input3 = "pwwkew"

    println(findLongestSubsequence(input1)) // Output: 3
    println(findLongestSubsequence(input2)) // Output: 1
    println(findLongestSubsequence(input3)) // Output: 3

}