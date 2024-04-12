package com.example.interviewlist.kotlin

//In Kotlin, both `val` and `const` are used to declare variables that are not supposed to change after their initial assignment. However, they serve different purposes and have different properties. Here’s a detailed comparison:
//
//### `val` (Value)
//- **Meaning**: `val` stands for "value" and is used to declare a read-only property or local variable. Once a `val` is assigned, it cannot be reassigned (i.e., it is immutable in terms of reassignment).
//- **Scope**: `val` can be used at both the local level (inside functions) and the class level (as properties).
//- **Initialization**: A `val` can be assigned a value at the time of declaration or within the constructor for class properties. It supports dynamic calculations at runtime, meaning its value can be determined during program execution.
//- **Custom Accessor**: You can define a custom getter for a `val`, which means every time the `val` is accessed, the custom getter can compute a value dynamically.
//
//**Example of `val`:**
//```kotlin
//class Example {
//    val createdAt: Long = System.currentTimeMillis()
//
//    val formattedDate: String
//        get() = formatDate(createdAt)
//}
//
//fun formatDate(timeMillis: Long): String {
//    // Converts time in milliseconds to a formatted date string.
//}
//```
//
//### `const` (Constant)
//- **Meaning**: `const` stands for "constant". It is a modifier that is used only with `val` and specifies that the variable is a compile-time constant. This means its value must be known at compile-time and cannot be assigned at runtime.
//- **Scope**: `const` can only be used with properties declared at the top level or in objects (including companion objects), and it cannot be used with local variables.
//- **Initialization**: The value assigned to a `const val` must be a string or a primitive type that is determined at compile-time. It cannot be assigned a value that is determined at runtime, and it cannot use a custom getter.
//- **Usage**: `const val` is used when you need a constant that does not change and is accessible at compile time, similar to Java’s static final fields.
//
//**Example of `const`:**
//```kotlin
//object Config {
//    const val MAX_USER_COUNT: Int = 100
//    const val API_KEY: String = "12345abcdef"
//}
//```
//
//### Key Differences
//- **Runtime vs. Compile-time**: `val` properties can be initialized with values determined at runtime and can even execute logic in their getters. In contrast, `const val` must be initialized with compile-time constants.
//- **Accessibility**: `const val` can be used to create constants accessible similarly to static fields in Java, suitable for configuration values that never change during execution. On the other hand, `val` is more versatile and can be used in many more contexts, including as mutable fields with custom logic via getters.
//- **Optimization**: Accessing a `const val` is faster than accessing a `val` because `const val` is inline at compile time, meaning every usage of `const val` is replaced by the constant value directly in the compiled bytecode.
//
//Using `val` and `const` appropriately can lead to cleaner, more efficient, and safer Kotlin code. Choosing between them depends on whether you need a compile-time constant or a runtime immutable value.