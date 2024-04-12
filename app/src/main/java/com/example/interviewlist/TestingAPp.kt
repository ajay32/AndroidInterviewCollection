package com.example.interviewlist

// find the occurence of string "Ajay"  a-2, j-1
//fun main() {
//
//    val stringdata = "ajay"
//
//    val occurernce : MutableMap<Char, Int> = mutableMapOf()
//
//    for(char in stringdata) {
//        if(char in occurernce) {
//            occurernce[char] = occurernce[char]!!+1
//        } else {
//            occurernce[char] = 1
//        }
//    }
//
//    for((char, value) in occurernce) {
//        println("The occurece are $char and $value")
//    }
//
//}


//fun main() {
//
//    println(10 add 5)
//
//}
//
//infix fun Int.add(value: Int ) = this + value


// High order fun ... you pass

//fun abc( operation: (String) -> String) : String {
//    return operation("Yello")
//}
//
//fun main() {
//    val result = abc {
//       it
//    }
//
//    println(result)
//
//}


//========================================
// noinline example
fun main() {

    operation( {
        println("You are the success")
    }, {
        println("You are the failure")
    })
}

inline fun operation(success: () -> Unit,crossinline faliure: () -> Unit) {

    try {
        println("operation done successfully")
        success()
        faliure()
    } catch(e : Exception) {

    }
}

