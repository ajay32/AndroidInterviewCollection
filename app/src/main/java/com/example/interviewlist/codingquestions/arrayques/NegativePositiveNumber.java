package com.example.interviewlist.codingquestions.arrayques;

//Move all negative numbers to beginning and positive to end with constant extra space

// Approach -- if we sort the array negative will come at starting and positive at end

// Input: -12, 11, -13, -5, 6, -7, 5, -3, -6

import java.util.Arrays;

public class NegativePositiveNumber {

     static int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};

    public static void main(String args[]) {

        Arrays.sort(arr);  // O (n*log(n))

        for(int x : arr) {
            System.out.print(x + "");
        }
    }
}


