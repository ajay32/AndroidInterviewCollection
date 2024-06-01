package com.example.interviewlist.kotlin

// Functional interface with lambda
// interface having one method .. SAM
// SAM - only one abstract method

fun interface MyAction {
    fun actionListener()
}

fun main() {

    val action : MyAction = MyAction { println("This is my action") }

    action.actionListener()

    //======================

    val myAction2 : MyAction2 = object : MyAction2 {
        override fun myActionListener2() {
           println("Hello world")
        }
    }

    myAction2.myActionListener2()
}

//====================================


fun interface MyAction2 {
    fun myActionListener2()
}



//============================================

//In the Kotlin code you've provided, the keyword `object` is used to create an anonymous inner class that implements the `MyAction2` interface. This usage is a common pattern in Kotlin (and Java) for handling situations where you need to implement an interface for a one-time use, typically for callbacks or event listeners.
//
//### Detailed Explanation:
//
//1. **Creating an Instance of `MyAction`**:
//- The first part of your code creates an instance of a class `MyAction` which seemingly accepts a lambda expression in its constructor. This lambda is likely used to define some sort of action or callback within the `MyAction` class. The `actionListener()` method of this instance is then called, and it executes the lambda, printing "This is my action".
//
//```kotlin
//val action: MyAction = MyAction { println("This is my action") }
//action.actionListener()
//```
//
//2. **Using `object` to Create an Anonymous Inner Class**:
//- The second part involves the `object` keyword, which is used here to create an anonymous inner class that implements the `MyAction2` interface.
//
//```kotlin
//val myAction2: MyAction2 = object : MyAction2 {
//    override fun myActionListener2() {
//        println("Hello world")
//    }
//}
//myAction2.myActionListener2()
//```
//
//- `MyAction2` is an interface, and to create an instance of an interface directly (since you cannot instantiate an interface by itself), Kotlin requires that you provide an implementation of the interface at the point of creation. This is done using an anonymous class.
//- The `object : MyAction2` syntax starts the declaration of this anonymous class, and within the curly braces `{}`, you provide implementations for any abstract methods declared in the `MyAction2` interface. In this case, the `myActionListener2()` method is implemented to print "Hello world".
//- Finally, `myAction2.myActionListener2()` calls the implemented method, executing the code within.
//
//### What Does `object` Do Here?
//
//- **Object Declaration**: The `object` keyword in Kotlin is versatile and is used for creating objects of a class with modifications right at the point of instantiation. When used in this way (inside an expression), it creates an anonymous inner class.
//- **Anonymous Inner Class**: This is a class without a name that directly implements an interface or extends another class. It is useful for one-off implementations where a full class declaration would be unnecessarily verbose.
//- **Encapsulation**: This approach is commonly used in Android and other event-driven programming models to encapsulate the handling of a specific action directly in place, making the code more readable and self-contained.
//
//This pattern of using `object` to create instances of interfaces is especially common in Android for setting up listeners for events like clicks, completions, and other asynchronous tasks.
//
