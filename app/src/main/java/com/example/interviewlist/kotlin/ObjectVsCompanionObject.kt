package com.example.interviewlist.kotlin

// what is the difference between Object and Companion Object

//In Kotlin, both `object` and `companion object` serve unique purposes, but they have distinct uses and implications in terms of scoping, instantiation, and access. Understanding these differences is key to utilizing them effectively in your Kotlin programs.
//
//### Object
//
//In Kotlin, an `object` declaration introduces an object type, which is essentially a singleton. The `object` keyword is used to create a single instance of a class that can be accessed globally. This singleton instance is created the first time it is accessed, and the same instance is returned upon subsequent accesses.
//
//**Characteristics and Usage of `Object`:**
//- **Singleton Pattern**: Automatically enforces the singleton pattern without needing to write additional code to ensure only one instance exists.
//- **Global Access**: Provides a globally accessible instance which can be accessed directly via the object's name.
//- **Initialization**: Lazy and thread-safe initialization at the point of first access.
//- **Use Cases**: Useful for creating utility functions, manager classes, or when a single shared instance is needed across the application.
//
//**Example:**
//```kotlin
//object NetworkManager {
//    fun fetch(url: String): Data {
//        // Implementation
//    }
//}
//
//fun main() {
//    val data = NetworkManager.fetch("http://example.com")
//}
//```
//
//### Companion Object
//
//A `companion object` in Kotlin is a way to include static-like members (methods or properties) within a class. Unlike Java, Kotlin does not have static methods or properties. Companion objects are used to hold members that can be accessed without creating an instance of their containing class but still have access to private class members.
//
//**Characteristics and Usage of `Companion Object`:**
//- **Class Scoped**: Members of a companion object are scoped to the instance of the containing class but accessed in a static-like manner.
//- **Access Modifiers**: Companion objects can access private members of the containing class, allowing them to interact with class-specific data.
//- **Initialization**: Created when the containing class is loaded, similar to static initialization in Java.
//- **Use Cases**: Commonly used for factory methods, constants, or when you need function or property access that doesn't require a class instance but still needs access to the class internals.
//
//**Example:**
//```kotlin
//class User private constructor(val username: String) {
//    companion object {
//        fun createGuest(): User {
//            return User("guest")
//        }
//    }
//}
//
//fun main() {
//    val guestUser = User.createGuest()
//}
//```
//
//### Key Differences
//
//- **Scope and Usage**: `object` is used for defining a singleton instance which can be used globally across the application, while a `companion object` is used within a class to provide static-like functionality.
//- **Accessibility**: Methods within an `object` are accessed through the object's name globally, whereas methods within a `companion object` are accessed using the containing class name.
//- **Instance Relation**: An `object` is a standalone singleton, while a `companion object` is associated with a class instance and can access its private members.
//
//Both `object` and `companion object` are powerful features of Kotlin, providing elegant solutions to scenarios that in other languages might require more boilerplate code (like singletons or static methods). Understanding when and how to use each can help you design more effective and idiomatic Kotlin code.
//