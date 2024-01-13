package com.example.interviewlist.solid.java.srp_ocp;


// LSP - it says objects of super class shall be replacable with the object of Subclass
// ISP - no client should not depend on methods It does not use
// DIP - high level modules should not depend upon low level modules. both should depend on abstractions



// LSP - no subclass so LSP does not apply here (no violation)
// ISP does not apply here because it does not implement any interface (no violation)
// DIP does not apply here because it is not interacting with other classes like DB, Network  (no violation)
// SRP - class should be responsible for managing user data (POJO) not to print it (Violation)
// OCP - violation
public class Employee {
    public String name; // breaking - encapsulation fields should be private and getter method to access them
    public int age;

    // it is also violating the OCP - suppose if we need to frequently change the print method to print different we have to modify the class
    public void printEmployeeDetails() { // should not print it - SRP violation
        System.out.println("Name: " + name + ", Age: " + age);
    }

    // ... other methods ...
}


// Correct Version is below

 class Employee1 {
    private String name;
    private int age;

    public Employee1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

 class EmployeePrinter {
    public void printEmployeeDetails(Employee1 employee) {
        System.out.println("Name: " + employee.getName() + ", Age: " + employee.getAge());
    }
}
