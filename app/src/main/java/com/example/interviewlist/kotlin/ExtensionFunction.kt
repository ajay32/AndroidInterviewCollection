package com.example.interviewlist.kotlin

//In Kotlin, extension functions provide a powerful way to add functionality to existing classes without inheriting from them or using any type of design pattern such as Decorator. This feature is particularly useful when you need to extend the capabilities of a class from a third-party library or the Kotlin standard library, where you don't have the ability to directly alter the source code.
//
//### How Extension Functions Work
//
//Extension functions are declared with a type that they extend followed by a dot (`.`), which indicates that the function is to be added to objects of that type. Here’s the basic syntax:
//
//```kotlin
//fun TypeName.extensionFunctionName(parameters): ReturnType {
//    // body of function
//}
//```
//
//### Example of Creating an Extension Function
//
//Suppose you often need to trim a string and convert it to an integer in your application. You can create an extension function for the `String` class to simplify this:
//
//```kotlin
//fun String.toIntOrZero(): Int {
//    return this.trim().toIntOrNull() ?: 0
//}
//```
//
//Now, any string can call `toIntOrZero()` to perform this operation:
//
//```kotlin
//val result = " 123 ".toIntOrZero()  // result will be 123
//```
//
//### Benefits of Using Extension Functions
//
//1. **Clarity and Readability**: They can make your code more readable and expressive by allowing you to call methods on objects as if they were defined in the object’s class.
//2. **Reduce Boilerplate**: Avoid repetitive code throughout your application.
//3. **Safe to Use**: They don’t actually alter the classes they extend. Instead, they are resolved statically and behave more like static methods. This means they are very safe to use without fear of breaking existing code.
//
//### Using Extension Functions in Real-World Scenarios
//
//Here’s a more complex example. Imagine you have multiple fragments in an Android application, and you frequently need to add arguments to them:
//
//```kotlin
//fun Fragment.setArgument(key: String, value: String) {
//    val args = this.arguments ?: Bundle()
//    args.putString(key, value)
//    this.arguments = args
//}
//```
//
//With this extension function, you can now easily add arguments to any fragment:
//
//```kotlin
//val myFragment = MyFragment()
//myFragment.setArgument("key", "value")
//```
//
//### Important Points
//
//- **No Override**: Extension functions do not actually insert new members into a class; they are resolved statically and can't override existing functions.
//- **Visibility**: Extension functions can only access the public and internal members of the extended type.
//- **Discoverability**: While they are useful, extension functions should be used judiciously as they can lead to a less discoverable API, especially in large codebases. It's often better to limit their visibility to where they are needed.
//
//Extension functions are a versatile feature in Kotlin that help you write more concise and expressive code. They are integral to idiomatic Kotlin programming, making it easier to work with existing types.
//