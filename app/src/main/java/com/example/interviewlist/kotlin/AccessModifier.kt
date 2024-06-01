package com.example.interviewlist.kotlin

//Access modifiers in Kotlin control the visibility of classes, objects, interfaces, constructors, functions, properties, and their setters. Understanding access modifiers is essential for managing encapsulation and designing secure and maintainable code. Below are some common interview questions related to access modifiers in Kotlin, along with detailed answers to help you prepare:
//
//### Question 1: What are the different access modifiers available in Kotlin?
//
//**Answer:**
//Kotlin provides four visibility modifiers:
//1. **`public`**: This is the default modifier. A public member is visible everywhere in the application. If no visibility modifier is specified, it’s public by default.
//2. **`private`**: Visible only within the file or class where it is declared. In the case of a class, private members are visible only within the class itself.
//3. **`protected`**: Similar to `private`, but it is also visible in subclasses. Note that Kotlin does not support `protected` at the top level (i.e., for classes and functions that are not inside any class).
//4. **`internal`**: Visible everywhere in the same module. A module is a set of Kotlin files compiled together, like an IntelliJ IDEA module, a Maven project, or a Gradle source set.
//
//### Question 2: How does Kotlin's `internal` access modifier differ from Java’s `package-private`?
//
//**Answer:**
//The `internal` modifier in Kotlin is similar to Java's `package-private` in that it restricts access outside certain boundaries. However, while `package-private` restricts access to other classes within the same Java package, `internal` extends visibility to the entire module where the code is compiled. This means any code within the same module (which could contain multiple packages) can access `internal` members.
//
//### Question 3: Can a top-level declaration in Kotlin be `protected` or `private`?
//
//**Answer:**
//In Kotlin, top-level declarations, which are declarations outside of any class or object, cannot be `protected` because there is no higher level of encapsulation that would inherit the protected members. However, top-level declarations can be `private`, meaning they are confined to the file in which they are declared. They can also be `internal`, which restricts their visibility within the same module.
//
//### Question 4: What is the default visibility of a class and its members in Kotlin?
//
//**Answer:**
//The default visibility of any class in Kotlin is `public`, meaning the class is accessible from any other part of the application or module. Similarly, any member (function, property) of a class is also `public` by default unless explicitly specified otherwise. This design encourages explicit declaration of restricted visibility, enhancing understandability and maintenance of code.
//
//### Question 5: Describe a use-case where you would use `private` and `protected` in a Kotlin class.
//
//**Answer:**
//- **`private`**: Use `private` when you want to hide a class member (field or method) from outside users of the class, often to encapsulate specific behaviors or data relevant only within the class itself. For example, a private method `calculateInterest` in a `BankAccount` class might handle calculations that should not be accessible or modified directly from outside the class.
//- **`protected`**: Use `protected` for allowing subclass-specific customization while still hiding the member from the public API. For example, a method `onCreate` in a `BaseActivity` class might be `protected`, allowing it to be overridden in derived activities but not called directly from outside the activity hierarchy.
//
//Understanding and applying these access modifiers properly is key to robust Kotlin application architecture, ensuring that components are well-encapsulated and that internal implementation details are not unnecessarily exposed.
//


//===================================================================

//Question 3: Can a top-level declaration in Kotlin be protected or private?
//Answer:
//In Kotlin, top-level declarations, which are declarations outside of any class or object, cannot be protected because there is no higher level of encapsulation that would inherit the protected members. However, top-level declarations can be private, meaning they are confined to the file in which they are declared. They can also be internal, which restricts their visibility within the same module.

// File: NetworkUtils.kt

// Private top-level function, accessible only within this file
private fun logNetworkError(error: String) {
    println("Network error: $error")
}

// Internal top-level function, accessible within the same module
internal fun setupNetworkConnection() {
    println("Setting up network connection")
    logNetworkError("No internet connection")  // Accessible here as it's in the same file
}

// Public top-level function, accessible from anywhere
fun connectToServer(url: String) {
    println("Connecting to server at $url")
    setupNetworkConnection()  // Accessible here because it's internal and within the same module
}

// Attempt to declare a protected top-level function - This will cause a compiler error
// protected fun configureNetwork() {
//     println("Configuring network settings")
// }


//===========================================================

