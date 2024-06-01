package com.example.interviewlist.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestedListExample {

    public static void main(String args[]) {

        List<List<Integer>> listOfList = new ArrayList<>();

        List<Integer> list1 = Arrays.asList(1,2,3);
        listOfList.add(list1);

        List<Integer> list2 = Arrays.asList(4,5,6);
        listOfList.add(list2);
;
        List<Integer> list3 = Arrays.asList(7,8,9);
        listOfList.add(list3);


        for(List<Integer> list: listOfList) {
            System.out.println(list);
        }


    }

}
