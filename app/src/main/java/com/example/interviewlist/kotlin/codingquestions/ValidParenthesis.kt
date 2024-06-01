package com.example.interviewlist.kotlin.codingquestions

//
//Problem statement
//You're given a string 'S' consisting of "{", "}", "(", ")", "[" and "]" .
//
//
//
//Return true if the given string 'S' is balanced, else return false.
//
//
//
//For example:
//'S' = "{}()".
//
//There is always an opening brace before a closing brace i.e. '{' before '}', '(' before ').
//So the 'S' is Balanced.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//[()]{}{[()()]()}
//Sample Output 1 :
//Balanced
//Explanation Of the Sample Input 1 :
//There is always an opening brace before a closing brace i.e. '{' before '}', '(' before '), '[' before ']'.
//So the 'S' is Balanced.
//Sample Input 2 :
//[[}[
//Sample Output 2 :
//Not Balanced
//Constraints:
//1 <= 'N' <= 10^5
//
//Where 'N' is the length of the input string 'S'.
//Time Limit: 1 sec

//
//To solve this problem, you can use a stack data structure. Here's the approach:
//
//Initialize an empty stack.
//Iterate through each character in the string.
//If the current character is an opening brace ('{', '(', '['), push it onto the stack.
//If the current character is a closing brace (')', '}', ']'), check if the stack is empty. If it is, return false because there is no corresponding opening brace for the current closing brace.
//If the stack is not empty, pop the top element from the stack and check if it matches the corresponding opening brace for the current closing brace. If it doesn't match, return false.
//After iterating through all characters, if the stack is empty, return true because all braces were balanced. If the stack is not empty, return false because there are unmatched opening braces.
//
//

fun returnValidParenthesis(s: String) : Boolean {

    val stack =  mutableListOf<Char>() // i will make it work as stack

    // use when for more than 1 conditon check (agar)

    for(char in s) { //moving char by char
        when(char) {
            '[','{','(' -> stack.add(char)
            ']' -> if(stack.isEmpty() || stack.removeAt(stack.lastIndex) != '[') return false
            '}' -> if(stack.isEmpty() || stack.removeAt(stack.lastIndex) != '{') return false
            ')' -> if(stack.isEmpty() || stack.removeAt(stack.lastIndex) != '(') return false
        }
    }

    return stack.isEmpty() // return true if stack is empty all balanced
}

fun main() {

    val str =  "[()]{}{[()()]()}"

    println(returnValidParenthesis(str))
}
