package com.example.interviewlist.kotlin.codingquestions

//Example :
//If the given input string is "Welcome to Coding Ninjas", then you should return "Ninjas Coding to Welcome" as the reversed string has only a single space between two words and there is no leading or trailing space.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//Welcome to Coding Ninjas
//Sample Output 1:
//Ninjas Coding to Welcome
//Explanation For Sample Input 1:
//You need to reduce multiple spaces between two words to a single space in the reversed string and observe how the multiple spaces, leading and trailing spaces have been removed.
//Sample Input 2 :
//I am a star
//Sample Output 2:
//star a am I
//Explanation For Sample Input 2:
//Your reversed string should not contain leading or trailing spaces.
//Constraints :
//0 <= N <= 10^5
//
//Time Limit: 1 sec
//Follow-up:
//If the string data type is mutable in your language, can you solve it in place with O(1) extra space?
//



//To solve this problem, you can follow these steps:
//
//Trim leading and trailing spaces from the input string.
//Split the input string into a list of words based on spaces.
//Reverse the list of words.
//Join the reversed list of words into a single string with a single space between each word.
//Return the final reversed string.


fun reverseAStringWordByWord(s: String) : String {

    val trimmedString = s.trim()
    val wordsList = trimmedString.split("\\s+".toRegex())

    val reversedWordsList = wordsList.reversed()

    val singleString = reversedWordsList.joinToString(" ")


    return singleString
}

fun main() {

    val str = "Welcome to coding ninjas"
    println(reverseAStringWordByWord(str))

}