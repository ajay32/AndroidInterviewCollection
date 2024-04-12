package com.example.interviewlist.kotlin

//==================== Concept of Sealed classes =======================

// how to create 1. Subclasses  2. inherit the parent class  3. Type saftey - u do not need else in when


sealed class NetworkResponse {

    object Loading : NetworkResponse()
    data class Success(val s: String) : NetworkResponse()
    data class Error(val e: String) : NetworkResponse()
}

fun main() {

    // lets hit a netowrk request
    val result = fetchDataFromNetowrk()

    when(result) {
        is NetworkResponse.Success -> print("Hello baby sucdess here")
        is NetworkResponse.Error -> print("Got error")
        is NetworkResponse.Loading -> println("Loading")
    }
}

fun fetchDataFromNetowrk() : NetworkResponse {

    // lets simulate the result

    var gotSuccessFromServer = true

    if(gotSuccessFromServer) {
        return NetworkResponse.Success("Hurray I got the success")
    } else {
        return NetworkResponse.Error("I got the error")
    }

}


////=================================== another example ============
//
//sealed class UiEvent {
//    object Click : UiEvent()
//    data class Scroll(val distance: Int) : UiEvent()
//    data class Swipe(val direction: String) : UiEvent()
//}
//
//fun handleUiEvent(event: UiEvent) {
//    when (event) {
//        is UiEvent.Click -> println("Clicked")
//        is UiEvent.Scroll -> println("Scrolled ${event.distance} units")
//        is UiEvent.Swipe -> println("Swiped ${event.direction}")
//    }
//}
//
//
////====================== another example
//
//sealed class UserAction {
//    object Tap : UserAction()
//    data class Swipe(val direction: String) : UserAction()
//    object LongPress : UserAction()
//}
//
//fun handleUserAction(action: UserAction) {
//    when (action) {
//        is UserAction.Tap -> println("User tapped the screen")
//        is UserAction.Swipe -> println("User swiped ${action.direction}")
//        is UserAction.LongPress -> println("User long-pressed on the screen")
//    }
//}