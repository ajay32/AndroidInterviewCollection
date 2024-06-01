package com.example.interviewlist.leetcode;

public class CharacterCountExample {
    public static void main(String[] args) {
        String s = "AABABBA";  // The bead string
        int[] count = new int[26]; // Array to count each letter (bead color)
        int maxCount = 0;  // Maximum count of any single bead color in the current window
        int start = 0;     // Start index of our sliding window

        for (int end = 0; end < s.length(); end++) {
            // Increment the count of the current bead color in the count array
            count[s.charAt(end) - 'A']++;
            // Update maxCount if the current bead's count is higher than maxCount
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);
            // Print current bead, its count, and maxCount after each addition
            System.out.println("Current Bead: " + s.charAt(end) +
                    ", Count: " + count[s.charAt(end) - 'A'] +
                    ", MaxCount: " + maxCount);
        }
    }
}
