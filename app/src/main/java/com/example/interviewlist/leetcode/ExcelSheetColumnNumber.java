package com.example.interviewlist.leetcode;

// https://www.youtube.com/watch?v=LTuSPIGoDlA&list=PLpO3gASfJEIJZqTAEQnLeYyz_vaNWLfHS
// A - 1
// AA - 26*1 + 1 = A(One circle A-Z) A (Just 1 A)
// AAA - 26*26 *1 + 26 * 1 + 1
// so lets create a formula
// AABA - start from right to left
//  26^3 * 1 + 26^2 * 1 + 26^1*1 +1 == total

// how to find the value for A or B or C - ex A - 65  lets find B = 66-65 + 1

// Goal is to find the total of columns - AABA

public class ExcelSheetColumnNumber {
    public static void main(String args[]) {
        int total = 0;
        int power = 0;
        String str = "AABA";

        // for string we use str.charAt(i)
        // for array we use str[i]

        for(int i = str.length()-1; i >= 0; i--) {
            char c = str.charAt(i);
            int elementValue = (int)c - 65 + 1;
            total += elementValue * Math.pow(26, power);
            power++;
        }

        System.out.println(total);
    }
}
