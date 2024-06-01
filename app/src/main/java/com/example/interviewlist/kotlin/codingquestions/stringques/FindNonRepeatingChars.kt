package com.example.interviewlist.kotlin.codingquestions.stringques

//==============================

// given a string you have to find the first non-repeacting character // swiss .. if does not match then it could return. null
// solu -> I will put each charachter in a map as a key and count as a value
// then I will go throught he input string again and get the char one by one and check if the first char i get with one count
//   then return count with 1 value
// it will return first value then that has 1 count
// Map<s, 3>
// map<w, 1>

fun findNonRepeatingCharacter(s: String) : Char? {
    var map = mutableMapOf<Char, Int>()

    for(char in s) {
        var count  = map.getOrDefault(char, 0)
        map[char] = count + 1
    }

    for(char in s) {
        if(map[char] == 1) {
            return char
        }
    }

    return null

}

