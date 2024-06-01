package com.example.interviewlist.kotlin

//================== lambda example ==========


//fun lambdaFun(b1: Int, b2: Int = 1,action : () -> Unit) {
//    action()
//    print("data is $b1 $b2")
//}
//
//fun main() {
//
//    lambdaFun(4) { println("Hello bello")}
//}


//fun lambdaFunction(action: () -> Unit) {
//    action()
//}
//
//fun main() {
//    lambdaFunction {
//        println("Hello world")
//    }
//}


//fun lambdaFunction(action: (Int, Int) -> Unit)  {
//    action(2, 3)
//}
//
//fun main() {
//    lambdaFunction { a , b ->
//        println("Hello world $a $b")
//    }
//}


fun lambdaFunction(action: (Int, Int) -> Int)  : Int{
    return action(2, 3)
}

fun main() {
    val result = lambdaFunction { a , b ->
        println("Hello world $a $b")

        a+b
    }
    println(result)

    //==========================

    lambdaFun2 { a, b ->  println("printlng $a $b") }

    //============

    val lamResult = lambdaFun3 { a, b ->
        a + b
    }

    println(lamResult)

}


fun lambdaFun2(action:(Int, Int) -> Unit) : Unit {

    action(2,2)

}

fun lambdaFun3(action: (Int, Int) -> Int) : Int { // if method returns lamda also should return
    return action(4,4)

}