package com.example.interviewlist.kotlin.flow


//SharedFlow
//SharedFlow is a more general-purpose hot flow that can emit values to an arbitrary number of collectors. It supports configurable replay, buffering, and backpressure handling, making it suitable for event-based communication.
//
//Characteristics:
//
//Does not have an initial value unless explicitly set with a replay cache.
//Supports replaying a configurable number of values to new subscribers.
//Suitable for event-driven architectures where events need to be multicast to multiple listeners.
//



//
//In the context of SharedFlow within Android development and Kotlin coroutines, "events" refer to any kind of message, notification, or piece of data that might be relevant for different parts of an application to respond to. These events can be generated from various sources within your application and are typically used to communicate changes or actions across different components or layers of your app. Here’s a detailed breakdown of the types of events and examples that SharedFlow might handle:
//
//Types of Events for SharedFlow
//User Interaction Events: These events originate from user actions within the app. Examples include button clicks, form submissions, gestures (like swipes or pinches), and other interactive elements within the UI.
//Network Status Changes: Events related to changes in network connectivity. For instance, notifying various parts of the application when the device connects to or disconnects from the internet, or when a Wi-Fi connection switches to a mobile data connection.
//Data Updates: Notifications about changes in data that various components of the application might need to react to. For example, updates in user data, configuration settings, or new data available from a sync operation.
//Background Task Completion: Events that signal the completion of background tasks, such as the end of a long-running calculation, file download, or database migration.
//Error and Status Messages: Broadcasting error messages or status updates that need to be handled or displayed by multiple parts of the application, such as a critical error notification or a system-wide alert.
//Navigation Events: Events that control or suggest navigation within the app, which could be used in a larger coordinator or navigator component to control the flow of screens or activities based on user actions or other conditions.

//User Interaction Notification
//Suppose you have an app with a complex UI, including multiple fragments that need to react to user actions in a centralized toolbar.
//
//class ToolbarViewModel : ViewModel() {
//    private val _toolbarEvents = MutableSharedFlow<ToolbarAction>()
//    val toolbarEvents = _toolbarEvents.asSharedFlow()
//
//    fun sendAction(action: ToolbarAction) {
//        viewModelScope.launch {
//            _toolbarEvents.emit(action)
//        }
//    }
//}
//
//// In Fragments
//viewModel.toolbarEvents.collect { action ->
//    when (action) {
//        ToolbarAction.BACK -> handleBackNavigation()
//        ToolbarAction.EDIT -> enableEditMode()
//        // Handle other actions
//    }
//}
//
//
//
//
//
//Network Status Updates
//In an application that needs to adjust its behavior based on network availability, such as disabling certain features or displaying a status bar when offline.
//class NetworkStatusManager : ViewModel() {
//    private val _networkStatus = MutableSharedFlow<Boolean>() // True if online, False if offline
//    val networkStatus = _networkStatus.asSharedFlow()
//
//    fun updateNetworkStatus(isOnline: Boolean) {
//        viewModelScope.launch {
//            _networkStatus.emit(isOnline)
//        }
//    }
//}
//
//// In various UI components
//viewModel.networkStatus.collect { isOnline ->
//    if (!isOnline) {
//        showOfflineIndicator()
//    } else {
//        hideOfflineIndicator()
//    }
//}


//StateFlow
//StateFlow is a type of hot flow that always holds a value and emits the current state to new subscribers immediately upon collection. It's essentially designed to represent a state over time, making it ideal for data-binding scenarios where UI needs to reflect the current state.
//
//Characteristics:
//
//Always holds one latest value.
//State is persistent and emits the latest value to new subscribers.
//Typically used to represent and observe state changes in UI.
//Example Use Case in Android:
//Suppose you have an app where users can toggle a setting that affects other parts of the UI dynamically. A StateFlow can be used to hold the state of this setting.
//
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//
//class SettingsViewModel : ViewModel() {
//    private val _uiMode = MutableStateFlow(DarkModeEnabled)
//    val uiMode = _uiMode.asStateFlow()
//
//    fun toggleUiMode() {
//        _uiMode.value = !_uiMode.value
//    }
//}
//
//// In your Activity or Fragment:
//viewModel.uiMode.collect { isDarkMode ->
//    updateUiMode(isDarkMode)
//}
//