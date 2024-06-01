package com.example.interviewlist.kotlin

//In Kotlin, the `lateinit` modifier is used with mutable properties (var), indicating that the property will not be assigned a value at the time of object creation but will be initialized later in the code before any operations are done on it.
//
//If you try to access a `lateinit` variable before it has been initialized, Kotlin will throw an `UninitializedPropertyAccessException`. This exception indicates that you're trying to use a property that hasn't been set up with a value yet.
//
//Here's an example of how this might occur:
//
//```kotlin
class MyClass {
    lateinit var myProperty: String
}

fun main() {
    val myClass = MyClass()
    println(myClass.myProperty) // This line will throw an exception
}


//If you run this code, you will get an `UninitializedPropertyAccessException` with a message similar to "lateinit property myProperty has not been initialized" because `myProperty` is being accessed before it has been assigned a value.
//
//To safely check if a `lateinit` var has been initialized, you can use the `::property.isInitialized` syntax provided by Kotlin:
//

//if (::myProperty.isInitialized) {
//    println(myClass.myProperty)
//} else {
//    println("myProperty has not been initialized")
//}


//This way, you can prevent the `UninitializedPropertyAccessException` by ensuring that the property has been initialized before attempting to use it.