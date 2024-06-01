package com.example.interviewlist.kotlin.jetpackcompose


//Jetpack Compose functions, often referred to as composables, follow a lifecycle that is somewhat different from traditional Android components like activities or fragments. Compose functions are designed to react to data changes and recompose efficiently when needed. Understanding this lifecycle is key to making the most out of Compose's capabilities and ensuring optimal performance for your application.
//
//### Lifecycle of a Composable Function
//
//1. **Composition**
//- **Initial Composition**: When a composable function is first called, it is composed. This is where it translates the provided data and state into a UI tree (or hierarchy). The initial composition sets up the baseline of what the UI looks like based on the current state.
//- **Recomposition**: If any of the state or data that the composable depends on changes, the composable function will be called again to re-compose the UI. Recomposition in Compose is selective; only the composables that depend on the changed data are recomposed, not the entire tree.
//
//2. **Placement**
//- Once composition or recomposition determines the structure and properties of the UI components, the next phase is placement. This involves laying out each composable on the screen, determining their sizes and positions based on constraints from parent composables and the device screen.
//
//3. **Drawing**
//- After placement, the next phase is drawing, where the composed and placed UI is actually rendered onto the screen. This involves painting the UI elements according to the properties defined during the composition phase (like colors, shapes, etc.).
//
//### Key Concepts Related to Lifecycle
//
//- **State**: State in Compose is what triggers recomposition. When state that a composable function reads changes, the framework automatically schedules the composable function for recomposition. This state-driven approach ensures that the UI is always consistent with the underlying data.
//
//- **Remember**: The `remember` function is crucial in the lifecycle of a composable. It is used to remember state or calculate values that should only be recomputed when inputs change, not on every recomposition. This helps in optimizing performance by avoiding unnecessary calculations.
//
//- **DisposableEffect**: This is used for managing side effects within composables that need cleanup when the composable leaves the composition or when its key changes. For example, setting up event listeners or subscriptions.
//
//- **LaunchedEffect**: Used for executing suspend functions within composables, `LaunchedEffect` is key when you need to perform asynchronous operations or side effects that do not require cleanup but need to be rerun based on specific keys.
//
//### Lifecycle Example
//
//Here’s a simple example to illustrate how recomposition works:
//
//```kotlin
//@Composable
//fun TimerExample() {
//    val time = remember { mutableStateOf(0) }
//
//    // LaunchedEffect to increment the time
//    LaunchedEffect(key1 = Unit) {
//        while (true) {
//            delay(1000)  // wait for 1 second
//            time.value++  // increment time
//        }
//    }
//
//    // Text recomposes every time 'time' changes
//    Text("Timer: ${time.value} seconds")
//}
//```
//
//In this example:
//- `time` is a state remembered across recompositions.
//- `LaunchedEffect` runs a continuous loop that increments `time` every second. Since `time` is a state variable, every increment causes the `Text` composable to recompose and display the updated value.
//
//This example shows how composables react to state changes and how their lifecycle is driven by changes in the state they depend on. Compose's ability to selectively recompose based on changes in state ensures efficient updates, minimizing the performance impact on your application.
//
//