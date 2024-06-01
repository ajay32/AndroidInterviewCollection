package com.example.interviewlist.designpatterns

//================================ chain of Responisbility

// Money Request ->[Payment Handler] Bank (<500) -> CreditCard (<2000) -> Paypal -> Request Done

abstract class PaymentHandler {
    var paymentHandler: PaymentHandler? = null

    abstract fun handlePayment(amount: Double)

    fun setNextHandler(ph: PaymentHandler) { // all these classes have same method with same param so in abstract class
        paymentHandler = ph
    }


}

class BankHandler : PaymentHandler() {
    override fun handlePayment(amount: Double) {
        if (amount < 500)
            println("Bank processing $amount amount")
        else
            paymentHandler?.handlePayment(amount)
    }
}

class CreditCardHandler : PaymentHandler() {
    override fun handlePayment(amount: Double) {
        if (amount < 2000)
            println("Credit Card processing $amount amount")
        else
            paymentHandler?.handlePayment(amount)
    }
}

class PaypalHandler : PaymentHandler() {
    override fun handlePayment(amount: Double) {
        println("Paypal processing $amount amount")
    }
}

fun main() {
    val bankHandler = BankHandler()
    val creditCardHandler = CreditCardHandler()
    val paypalHandler = PaypalHandler()

    bankHandler.setNextHandler(creditCardHandler)
    creditCardHandler.setNextHandler(paypalHandler)

    bankHandler.handlePayment(500.00)
    bankHandler.handlePayment(300.00)
    bankHandler.handlePayment(1800.00)
    bankHandler.handlePayment(2100.00)

}
