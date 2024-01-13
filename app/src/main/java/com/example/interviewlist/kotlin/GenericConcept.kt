package com.example.interviewlist.kotlin


// we can send diff type of param to class (type T) so we also have to make a class of type T
class GenericConcept<T>(val item: T)

fun main() {

    val obj1 = GenericConcept(12)
    val obj2 = GenericConcept("Hello")

    println(obj1.item)
    println(obj2.item)
}