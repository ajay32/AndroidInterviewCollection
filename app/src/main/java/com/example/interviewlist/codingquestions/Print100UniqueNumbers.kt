package com.example.interviewlist.codingquestions

import kotlin.random.Random

//Create ur own logic to save 100 values
//Print 1-100 unique number using random function
// fun getRandomInt(): Int {
//    return (1 + Random.nextInt(0, 100))
//}


// This method initializes a list of numbers from 1 to 100 and then shuffles it using the shuffled() function. This guarantees that all numbers from 1 to 100 are used exactly once, and in a random order

//fun main() {
//    val numbers = (1..100).toList().shuffled()
//
//    numbers.forEach { number -> println(number) }
//}


//=================================


// In this method, we keep generating random numbers and adding them to a Set until it contains 100 unique numbers. The nature of a set ensures that no duplicates are added. Once the set has 100 elements, we print them out. This method might take longer and have more iterations due to potential duplicate values in random generation, especially as the set size approaches 100.
// take set and loop until 100

fun main() {
    val set = mutableSetOf<Int>()

    while(set.size < 100)  {  // we will loop until set size is less than 100
        set.add(getRandomNumber())
    }

    set.forEach {
        println(it)
    }
}

fun getRandomNumber() : Int {
    return (1 + Random.nextInt(0,100))
}

//what this line means  return (1 + Random.nextInt(0, 100))

//The line `return (1 + Random.nextInt(0, 100))` in Kotlin is intended to generate a random integer between 1 and 100, inclusive. However, there seems to be a slight mistake in the parameters passed to the `nextInt` function that affects the intended range. Let's break it down to understand and correct it:
//
//### Understanding `Random.nextInt(start, end)`
//
//The `Random.nextInt` function in Kotlin is used to generate a random integer. The way the function is defined, `nextInt(from, until)` generates a random integer that is greater than or equal to `from` and less than `until`. Therefore, it does not include the upper limit (`until`).
//
//### Given Code Explanation
//
//- `Random.nextInt(0, 100)` generates a random integer from `0` to `99`. It includes `0` and excludes `100`.
//- Adding `1` to the result (`1 + Random.nextInt(0, 100)`) shifts this range from `1` to `100`.
//
//So, when you combine these parts, the line effectively generates a random integer within the range of `1` to `100` inclusive. Here's what happens:
//
//1. `Random.nextInt(0, 100)` picks a random number from `0` to `99`.
//2. Adding `1` to each of these results transforms the range to start from `1` (when the random number is `0`) to `100` (when the random number is `99`).
//
//### Correct Interpretation
//
//If the goal is to always return a random number between `1` and `100` inclusive, the line of code you provided is correct and does exactly that. The initial expression might look a bit confusing due to the parameters used with `nextInt`, but the addition of `1` adjusts the range to include `100` and exclude `0`, thus aligning it perfectly with the usual human-friendly numbering that starts from `1`.
//
//### Simplified Version
//
//To achieve the same without addition, you could directly use:
//```kotlin
//return Random.nextInt(1, 101)
//```
//This line would inherently generate a random integer from `1` to `100` inclusive, which might be more intuitive to read and understand at a glance.
//