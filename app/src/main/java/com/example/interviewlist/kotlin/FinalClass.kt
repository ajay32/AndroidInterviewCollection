package com.example.interviewlist.kotlin

//In Kotlin, classes are `final` by default, which means they cannot be subclassed without explicitly declaring them as `open` or abstract. This design decision was intentional and serves several purposes:
//
//### 1. **Promotion of Composition over Inheritance**
//
//One of the foundational principles behind Kotlin's design is to encourage composition over inheritance. Inheritance can lead to a more fragile software architecture, particularly when misused or overused. It often results in a tightly coupled code structure where subclasses are heavily dependent on the implementation details of their parent classes. This can make the codebase more difficult to understand and maintain.
//
//By making classes `final` by default, Kotlin nudges developers towards using composition, which involves creating objects which contain other objects (in other behaviors or state), rather than extending classes. Composition is generally favored for its flexibility and the ability to create more modular, decoupled, and easily testable code.
//
//### 2. **Avoiding the Fragile Base Class Problem**
//
//The fragile base class problem occurs in object-oriented programming when changes to a base class break subclasses that were previously working. Since subclasses can depend on the behavior of the parent class, seemingly safe modifications to a base class can lead to subtle bugs in subclasses.
//
//By requiring explicit intent to make a class inheritable (through the `open` keyword), Kotlin protects classes from being inadvertently extended and thus becoming fragile bases.
//
//### 3. **Enhancing Understandability and Maintainability**
//
//If a class is not designed and documented with inheritance in mind, its subclassing can lead to improper usage and bugs. Forcing developers to think about whether a class should be inheritable or not encourages better design and more robust, maintainable code.
//
//### 4. **Optimization by the JVM**
//
//Classes that are final can sometimes be optimized better by the Java Virtual Machine (JVM). The JVM can perform certain optimizations such as method inlining when it knows a method cannot be overridden. This can lead to performance improvements, although modern JVMs are quite good at optimizing even in the presence of inheritance.
//
//### Implementing `open` Classes
//
//To allow a class to be extended, Kotlin requires explicitly making the class `open`:
//
//    ```kotlin
//open class Base {
//    open fun v() {}  // This function can also be overridden
//}
//
//class Derived : Base() {
//    override fun v() {}  // Overrides the Base class's function
//}
//```
//
//### Conclusion
//
//Making classes `final` by default aligns with Kotlin's philosophy of safe and effective software development. It encourages developers to be more deliberate about their class design, promoting patterns that lead to more maintainable and robust applications. This approach also helps avoid common pitfalls associated with inheritance, thus supporting better software practices.
//
//