package com.example.interviewlist.java.basic;

public class StaticMethodOverloading {

    public static void main(String ags[]) {

        System.out.println(OverloadingTest.print(2,2));
        System.out.println(OverloadingTest.print(2.2,2.2));
        System.out.println(OverloadingTest.print(2));
    }
}


class OverloadingTest {

    public static int print(int a, int b) {
        return a+b;
    }

    public static double print(double a, double b) {
        return a+b;
    }

    public static int print(int a) {
        return a;
    }

}

