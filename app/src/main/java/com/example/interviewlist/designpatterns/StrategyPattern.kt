package com.example.interviewlist.designpatterns

//======================================================

 //Stragegy Pattern

interface PaymentStrategy {
    fun processPayment(amount: Double)
}

class CreditCardPayment : PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("process the amount using credit card $amount")
    }
}

class PaypalPayment : PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("process the amount using Paypal card $amount")
    }

}

class UPIPayment : PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("process the amount using UPI card $amount")
    }

}

class PaymentProcessor(val amount: Double) {

    var paymentStrategy : PaymentStrategy? = null

    fun setPaymentStragegy(ps : PaymentStrategy) {

        paymentStrategy?.let {
            paymentStrategy = null
        }

        paymentStrategy = ps
    }

    fun processPayment() {
        paymentStrategy?.processPayment(amount)
    }

    fun finalize() {
        paymentStrategy?.let {
            paymentStrategy = null
        }
    }

}

fun main() {

    val amount = 11.00

    val creditCardPayment : PaymentStrategy = CreditCardPayment()

    val paymentProcessor : PaymentProcessor = PaymentProcessor(amount)
    paymentProcessor.setPaymentStragegy(creditCardPayment)
    paymentProcessor.processPayment()

}
