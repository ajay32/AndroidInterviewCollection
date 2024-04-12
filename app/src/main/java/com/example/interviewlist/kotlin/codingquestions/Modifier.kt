package com.example.interviewlist.kotlin.codingquestions

class A {
    fun callMethods() { // internally u can call all three methods
        internalMethod()
        privateMethod()
        protectedMethod()
    }

    internal fun internalMethod() {
        println("Internal Method Called")
        privateMethod()
    }

    private fun privateMethod() {
        println("Private Method Called")
        protectedMethod()
    }

    protected fun protectedMethod() {
        println("Protected Method Called")
    }
}

fun main() {
    val a = A()
    //a. callMethods()
    a. internalMethod()
   // a. privateMethod()   // we can not call private method outside of class
  //  a. protectedMethod() // we can not call protected method outside of class
}

// output

//Internal Method Called
//Private Method Called
//Protected Method Called