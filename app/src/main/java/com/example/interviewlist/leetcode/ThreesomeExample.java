package com.example.interviewlist.leetcode;


// we have array [-1 0 1 1 2 4]
// we will loop thorugh and make first element a and in rest we will find b + c combination
// we want if we add three elements of it. it should be a+b+c = 0
// i can do is like find two sum.. using two some algorithm (b + c) and mke it like -> b + c = 0-a
// there could be more than one three element combinations

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreesomeExample {

    public static void main(String[] args) {
        ThreesomeSolution solution = new ThreesomeSolution();
        int[] arr = {-1, 0, 1, 1, 2, -1, -4};
        List<List<Integer>> triplets = solution.findThreeSome(arr);

        for (List<Integer> list : triplets) {
            System.out.println(list);
        }
    }
}

class ThreesomeSolution {

    public List<List<Integer>> findThreeSome(int[] nums) {
        Arrays.sort(nums); // Sort the array once before the loop
        List<List<Integer>> listOfList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) { // Skip duplicate 'a' values
                twoSumSorted(i + 1, nums.length - 1, nums, -nums[i], listOfList);
            }
        }
        return listOfList;
    }

    private void twoSumSorted(int i, int j, int[] nums, int target, List<List<Integer>> listOfList) {
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--; // we need smaller numbers
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else { // nums[i] + nums[j] == target
                listOfList.add(Arrays.asList(-target, nums[i], nums[j]));
                while (i < j && nums[i] == nums[i + 1]) i++; // skip duplicate 'b'
                while (i < j && nums[j] == nums[j - 1]) j--; // skip duplicate 'c'
                i++;
                j--;
            }
        }
    }
}

// TOtal time complexity of 0(nLogn) + 0(n^2)