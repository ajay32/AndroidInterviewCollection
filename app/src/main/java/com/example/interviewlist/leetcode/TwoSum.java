package com.example.interviewlist.leetcode;


//https://www.youtube.com/watch?v=TXxwt1eFF98&list=PLzffTJx5aHaTFf02t0Cr47pamj8KWyFTg
// nums = [2,7,11,15] target = 9 return [0,1]

//Hashing technique  ..pick one element lets say 2 then 7 then 11
// 2 steps
// 1 put all the elemnts in the HashMap
// 2 search second elemnt from hasmap and  sum it with your pick element

import java.util.HashMap;

public class TwoSum {


    public static void main(String args[]) {

        Solution solution = new Solution();
        int arr[] = {2,7,11,15};  // three steps to pass an array as param - declare (arr), initilize and pass name
       // int[] x =   solution.twoSum( arr, 9); // in getting arry u dont need to declare

        int[] x =   solution.twoSum( arr, 4);

        // i will get only one element .. if u dont have to assume that solution might not be there in array u need to add check
        if(x.length > 0) {
            System.out.println("The value is "+x[0] + " " + x[1]);
        } else {
            System.out.println("no data found");
        }
    }
}

class Solution { // nums[2,7,11,15]
    public int[] twoSum(int [] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // put elements in hashmap
        for(int i =0; i< nums.length; i++) {
            map.put(nums[i], i); // putting element and its index
        }

        // picking up 1st element in searching in hasmap for 2nd element
        for(int i=0; i< nums.length; i++) {
          int num = nums[i]; //2
            // need to find the remaning element - 7
            int rem = target - num; //7

            if(map.containsKey(rem)) { // // now check if rem is in hashmap

                if(map.get(rem) == i) continue; // // we have condition not to return same indices

                return new int[] {i, map.get(rem)};
            }

        }


        // in case if we have failed to find any match return empty array
        return new int[]{};
    }
}

