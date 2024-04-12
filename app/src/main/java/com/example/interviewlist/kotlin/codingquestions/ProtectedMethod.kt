package com.example.interviewlist.kotlin.codingquestions

open class AA {  // make to open so that it could be sunclassed
    protected fun protectedMethod() {
        println("Protected Method Called")
    }
}

class B : AA() {
    fun callProtectedMethodFromA() {
        protectedMethod() // Accessing the protected method from the superclass
    }
}

fun main() {
    val b = B()
    b.callProtectedMethodFromA() // This indirectly calls the protected method of A
}


