package com.example.interviewlist.kotlin


// code is same as sealed class
//Sealed classes are best for a closely related set of types that are known at compile time and defined in the same file, allowing for exhaustive when checks and ensuring type safety.
//Sealed interfaces provide flexibility and are suited for defining contracts that can be implemented by a wider range of types, potentially across different files or modules. They still allow for exhaustive when checks but offer the added benefits of interface implementation, including the ability to implement multiple interfaces.
sealed interface PaymentMethod {
    data class CreditCard(val number: String, val expiryDate: String) : PaymentMethod
    data class PayPal(val email: String) : PaymentMethod
    object Cash : PaymentMethod
}

fun processPayment(method: PaymentMethod) {
    when (method) {
        is PaymentMethod.CreditCard -> println("Processing credit card payment")
        is PaymentMethod.PayPal -> println("Processing PayPal payment")
        is PaymentMethod.Cash -> println("Processing cash payment")
    }
}

//=============== another example ==============

sealed interface UserAction1{
    object Tap : UserAction1
    data class Swipe(val direction: String) : UserAction1
    object LongPress : UserAction1
}

fun handleUserAction1(action: UserAction1) {
    when (action) {
        is UserAction1.Tap -> println("User tapped the screen")
        is UserAction1.Swipe -> println("User swiped ${action.direction}")
        is UserAction1.LongPress -> println("User long-pressed on the screen")
    }
}

//============ multiple interface you can use in 1

// Sealed Interface
sealed interface Action {
    object Tap : Action
    data class Swipe(val direction: String) : Action
    object LongPress : Action
}

sealed interface State {
    object Loading : State
    object Idle : State
    object Error : State
}

// A class implementing multiple sealed interfaces
class UserInteraction : Action, State {
    // Implementation details here
}

