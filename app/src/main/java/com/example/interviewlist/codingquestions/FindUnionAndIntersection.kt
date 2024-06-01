package com.example.interviewlist.codingquestions

//======================== Find union and intersection of array

// Input: arr1[] = {1, 3, 4, 5, 7} // only elements are the distint in both array
//         arr2[] = {2, 3, 5, 6}
// Output: Union : {1, 2, 3, 4, 5, 6, 7}
//          Intersection : {3, 5}
//
// Input: arr1[] = {2, 5, 6}
//         arr2[] = {4, 6, 8, 10}
// Output: Union : {2, 4, 5, 6, 8, 10}
//          Intersection : {6}
//
//
  fun findUnion(array1: Array<Int>, array2: Array<Int>) : Set<Int> {
       return (array1.toSet() + array2.toSet()).sorted().toSet()

  }

   fun findIntersect(array1: Array<Int>, array2: Array<Int>) : Set<Int> {
       return (array1.toSet()).intersect(array2.toSet()).toSet()

  }

  fun main() {

      val inputArray1 = arrayOf(1, 3, 4, 5, 7)
      val inputArray2 = arrayOf(2, 3, 5, 6)

      println("this is the union ${findIntersect(inputArray1, inputArray2)}")


  }
