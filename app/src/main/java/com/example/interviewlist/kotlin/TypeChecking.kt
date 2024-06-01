package com.example.interviewlist.kotlin

// example of type checking ("is") for when and when with ==

 fun printType(type: Any) {

   when(type) {
       is String -> println("its a string")
       is Int -> println("its an int")
       else -> println("its an unknown type")
   }
 }

 fun typeAlreadyKnow(type: String) {
     when(type) {
         "Ajay" -> println("His name is ajay")
         "Kalu" -> println("His name is kalu")
     }
 }

 fun main() {
     printType("Ajay")
     printType(12)
     printType(2.2)

     typeAlreadyKnow("Ajay")
 }
