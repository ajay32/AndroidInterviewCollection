package com.example.interviewlist.kotlin

abstract class Animal1( name: String,  age: Int)

data class Dog(val name: String, val age : Int) : Animal1(name, age)

data class Cat(val name: String, val age : Int) : Animal1(name, age)

data class Wolf(val name: String, val age: Int, val height: Int) : Animal1(name, age)



fun main() {
    val dog =  Dog("Ajay", 32)
    val cat =  Dog("shinny", 32)
    val wolf = Wolf("MyWOlf", 23, 22)

    println("My dogs values are ${dog.name}  and age is  ${dog.age}")
}