package com.example.interviewlist.leetcode;

public class BeadChange {
    public static void main(String[] args) {
        String beads = "AABABBA";
        int magicPower = 1;  // You can change 1 bead's color
        System.out.println("Longest sequence with minimal changes: " + findLongestSequence(beads, magicPower));
    }

    public static int findLongestSequence(String s, int k) {
        int maxCount = 0, start = 0, maxLength = 0;
        int[] count = new int[26];  // Count beads of each color

        for (int end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);

            // Adjust the window size if more changes are needed than allowed
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }

            // Update the maximum length of the window
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
