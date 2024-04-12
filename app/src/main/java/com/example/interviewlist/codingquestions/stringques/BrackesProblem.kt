package com.example.interviewlist.codingquestions.stringques

//================== brackets problem in the string

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    for (char in s) {
        when (char) {
            '(', '{', '[' -> stack.addLast(char)
            ')' -> if (stack.isEmpty() || stack.removeLast() != '(') return false
            '}' -> if (stack.isEmpty() || stack.removeLast() != '{') return false
            ']' -> if (stack.isEmpty() || stack.removeLast() != '[') return false
        }
    }
    return stack.isEmpty()
}

fun main() {
    println(isValid("()")) // Output: true
    println(isValid("()[]{}")) // Output: true
    println(isValid("(]")) // Output: false
    println(isValid("({[]})")) // Output: true
}