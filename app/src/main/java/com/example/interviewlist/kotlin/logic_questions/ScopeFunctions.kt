package com.example.interviewlist.kotlin.logic_questions


//Question: What are the names printed by this program and why?
data class User(var name: String, var age: Int)

fun main() {
    val user = User("Alice", 25)
    val updatedUser = user.apply {
        name = "Bob"
    }.let {
        User("Charlie", 30)
    }
    println(user.name)
    println(updatedUser.name)
}

//Output
//Bob
//Charlie

//Code Breakdown
//Data Class Declaration:
//data class User(var name: String, var age: Int)
//This is a standard data class in Kotlin with two mutable properties: name and age.
//Creating an Instance of User:
//val user = User("Alice", 25)
//An instance of User is created with the name "Alice" and age 25. This instance is assigned to the variable user.
//Using apply Scope Function:
//user.apply { name = "Bob" }
//The apply function is called on the user object. Inside the apply block, the name property of the user object is modified to "Bob".
//The apply function returns the object it was called on after executing the block. Thus, it returns the user object itself, but now with the name property changed to "Bob".
//Using let Scope Function:
//.let { User("Charlie", 30) }
//The let function is then chained after the apply function. The result of the previous apply function (which is the modified user object) is passed into the let function. However, the block within let doesn't use the incoming object. Instead, it creates a new User object with the name "Charlie" and age 30.
//The let function always returns the result of the block inside it, which in this case, is a new User object with different properties.
//Assigning Result to updatedUser:
//val updatedUser = ...
//The new User object returned from the let block is assigned to updatedUser.



//You're right to consider the `val` keyword's implications. When you declare a variable as `val` in Kotlin, it means the reference to the object cannot be changed to point to a different object after it is initially set. However, `val` does not imply immutability of the object itself; it only makes the variable reference immutable.
//
//### Understanding `val` and Object Mutability
//
//In your example:
//```kotlin
//val user = User("Alice", 25)
//```
//- `user` is a `val`, so you cannot reassign `user` to point to another `User` or any other object (`user = User("Charlie", 30)` would result in a compile-time error).
//- However, `User` is a `data class` with mutable properties (`var`). This means the properties of the `User` object (`name` and `age`) can be changed, even though the reference `user` is declared as `val`.
//
//### How `apply` Changes the User Object
//
//When you use `apply` on the `user` object:
//    ```kotlin
//user.apply {
//    name = "Bob"
//}
//```
//- You're calling the `apply` scope function on the `user` instance. Inside `apply`, `this` refers to the `user` object itself.
//- You modify the `name` property of the `user` object. Since `name` is a `var`, it's allowed to change its value.
//- `apply` does not change the reference of `user`; it remains the same. What changes is the content (properties) of the `User` object that `user` refers to.
//- `apply` returns the `user` object after modifying its properties, allowing for chaining other operations or assignments. In this case, the returned object isn't used for another assignment because you're just chaining the `let` function next.
//
//### Illustration with Mutable vs. Immutable Properties
//
//If `User` was defined with `val` properties, like this:
//```kotlin
//data class User(val name: String, val age: Int)
//```
//Then trying to modify the properties inside `apply` would result in a compile-time error:
//```kotlin
//user.apply {
//    name = "Bob"  // Compile error, because `name` is a `val` and cannot be reassigned
//}
//```
//In summary, `val` and `var` in Kotlin work as follows:
//- **`val` (value)**: You cannot reassign the variable to point to a different object after it is initialized. The reference is immutable.
//- **`var` (variable)**: You can reassign the variable to point to different objects, and the reference is mutable.
//- **Properties declared as `var`**: Can be changed or mutated.
//- **Properties declared as `val`**: Cannot be changed or mutated once set.
//
//Your original code works because while the `user` variable cannot be reassigned, the object it points to has mutable properties that you are changing with `apply`.
//