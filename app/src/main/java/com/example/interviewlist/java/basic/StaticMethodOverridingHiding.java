package com.example.interviewlist.java.basic;




//Overriding also doesn't apply to static methods. When both a subclass and a superclass contain methods with the same name and matching parameter types,
//        it's called method hiding. The method that gets invoked is determined by its reference type rather than its object type.

// static method overridng is called Method Hiding


class Parent {
    static void display() {
        System.out.println("Displaying the data");
    }
}

class Child extends Parent {
     static void display() {
        System.out.println("Displaying the Child");
    }
}



public class StaticMethodOverridingHiding {

    public static void main(String ags[]) {
        //refrence type

        Parent p = new Child();
        p.display(); // it should be vaise to
        Parent.display();
        Child.display();

    }
}

//===============================

 //   Java doesn't support method overloading with the same method signature but different static status.