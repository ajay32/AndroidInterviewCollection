package com.example.interviewlist.kotlin


// lazy example

data class Person(val name: String, val age: Int) // its not a fun its a class construtor so that is why use var/ val

fun main() {

    val lazyPerson: Person by lazy {
        Person("ajay", 24)
    }

    println("Person deatils is ${lazyPerson.name} and age is ${lazyPerson.age}")
}


// lazy examples
//fun main() {
//    val lazyValue: String by lazy {
//        "Hell world"
//    }
//
//    println(lazyValue)
//}
//
//fun main() {
//    val count : Int by lazy {
//        9
//    }
//    println(count)
//}
//


//=================


