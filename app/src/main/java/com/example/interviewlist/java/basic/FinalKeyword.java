package com.example.interviewlist.java.basic;

public class FinalKeyword {
//    public static void main(String args[]) {
//
//        Child child = new Child();
//        child.doTask();
//    }
}


//class Parent {
//
//    public final String name = "Ajay";
//     final void doTask() {
//        System.out.println("Doing some task");
//    }
//}
//
//class Child extends Parent {
//    @Override
//    void doTask() {
//        super.doTask();
//        name = "Kalia";
//        System.out.println("I am child class");
//    }
//}

//===================================================

//final class Animal {
//    void speak() {
//        System.out.println("Animal is speaking");
//    }
//}
//
//class Dog extends Animal {
//
//}

//===================================================================

// What is the purpose of the 'final' keyword?

//    In Java, the final keyword offers restrictions and benefits. It primarily maintains the immutability of different entities.
//
//        Core Functions
//        Class Immutability: Makes a class unextendable.
//        Method Immutability: Disallows method overriding.
//        Variable Immutability: Commands a constant value for primitives and a constant reference for objects.
//        Advantages
//        Enhanced Security: Avoids data tampering through unintended extensions, method modifications, or reassignments.
//        Code Clarity: Clarifies the intended use of class members, ensuring a reliable and coherent design.
//        Concurrent Safety: Guarantees thread-safe data in situations of code shared across threads.
//        Practical Applications
//        Inheritance Control: Effortlessly sets up classes that are not designed for extension. This is beneficial when aiming to preserve a rigorous design.
//
//        Performance Optimization: For primitive variables and simple data structures like Strings, using final eliminates the need for certain checks and operations, potentially speeding up the code execution.
//
//        Intelligent Compilation: Can be leveraged by Java's JIT (Just-In-Time) compiler to make certain assumptions that would otherwise necessitate costly runtime checks.

