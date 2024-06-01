package com.example.interviewlist.kotlin.jetpackcompose

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.service.autofill.UserData
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.delay

//In Jetpack Compose, the terms `LaunchedEffect` and `DisposableEffect` refer to built-in composable functions designed to handle side effects that operate under different conditions and have different use cases:
//
//### LaunchedEffect
//`LaunchedEffect` is used for executing suspend functions or launching coroutines within the composition. It's particularly useful for tasks that need to be performed in response to changes in state or composition inputs, like fetching data from a network when a component is displayed or a key changes.
//
//- **Key-based execution:** The key you pass to `LaunchedEffect` determines when the effect is run. If the key changes, the current coroutine is canceled, and a new coroutine starts with the new key. If the key is `Unit`, the effect runs only once when the component enters the composition.
//- **Cancellation and restart:** If the composable that called `LaunchedEffect` is removed from the composition, the coroutine is automatically canceled. This helps prevent memory leaks and ensures that coroutines don't continue to run after the UI that launched them has been removed.
//
//Example usage:

//LaunchedEffect(key1 = someState) {
//    someSuspendFunction()
//}

//
//### DisposableEffect
//`DisposableEffect` is used for managing cleanup logic for side effects that need explicit cleanup when a composable leaves the composition or when keys change. This is typically used for integrating with non-Compose managed resources, like event listeners, subscriptions, or any manually managed object lifecycle.
//
//- **Resource management:** You provide a setup block and a cleanup block. The setup block runs when the composable enters the composition or when the keys change. The cleanup block runs when the composable leaves the composition or before the setup block runs again due to a key change.
//- **Key-based reinitialization:** Similar to `LaunchedEffect`, the behavior of `DisposableEffect` can be controlled by keys. If the keys change, the current effect's cleanup logic is invoked, and the setup logic is re-run with the new keys.
//
//Example usage:

//DisposableEffect(key1 = someState) {
//    val listener = EventListener {
//        println("Event occurred")
//    }
//    eventSource.addListener(listener)
//
//    onDispose {
//        eventSource.removeListener(listener)
//    }
//}

//
//### Summary
//While `LaunchedEffect` is ideal for running and managing coroutines within Compose based on composition and changes in state, `DisposableEffect` is designed for managing lifecycle-sensitive side effects that involve cleanup, ensuring resources are not leaked outside the lifecycle of the composable where they are used.
//
//
//
//Certainly! Here are examples for both `LaunchedEffect` and `DisposableEffect` in Jetpack Compose, demonstrating their common use cases:
//
//### LaunchedEffect Example
//Let's say you have a composable function where you want to load data from a network API when a particular ID changes, and you want to display this data in your UI.
//

@Composable
fun UserProfile(id: String) {
    var userData by remember { mutableStateOf<UserData?>(null) }

    LaunchedEffect(key1 = id) {
      //  userData = fetchUserData(id)
    }

    if (userData != null) {
      //  Text("User Name: ${userData.name}")
    } else {
        CircularProgressIndicator()  // Show loading indicator while data is fetching
    }
}

suspend fun fetchUserData(id: String): com.example.interviewlist.kotlin.jetpackcompose.UserData {
    // Simulate network delay
    delay(1000)
    return UserData(id, "John Doe")
}
//
data class UserData(val id: String, val name: String)
//```
//In this example, `LaunchedEffect` is used to call a suspend function that fetches user data. The effect re-launches whenever the `id` changes, ensuring that the user data is always up to date.
//
//### DisposableEffect Example
//Now, let’s look at an example where you might use `DisposableEffect` to manage a sensor listener in an Android app. This could be useful for handling device orientation changes, for instance.
//
//```kotlin
@Composable
fun OrientationListener(onOrientationChanged: (Float) -> Unit) {
    val context = LocalContext.current

    DisposableEffect(context) {
        val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val sensorEventListener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                event?.values?.let { values ->
                    onOrientationChanged(values[0])  // Assume this is the orientation value
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }

        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_UI)

        onDispose {
            sensorManager.unregisterListener(sensorEventListener)
        }
    }
}

//
//    // Assuming you use the orientation value elsewhere in your UI
//}
//```
//In this `DisposableEffect` example, the effect manages the lifecycle of a sensor event listener. The listener is registered when the composable enters the composition and unregistered when it leaves or the context changes, preventing memory leaks and unnecessary sensor data processing.
//
//Both of these examples show how `LaunchedEffect` and `DisposableEffect` are tailored for specific types of side effects in Jetpack Compose, handling them safely and efficiently according to the composables' lifecycle.
//
//
