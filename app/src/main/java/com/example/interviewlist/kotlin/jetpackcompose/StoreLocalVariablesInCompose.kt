package com.example.interviewlist.kotlin.jetpackcompose

//In Jetpack Compose, you can manage and store local variables using state and remember functions. These tools help you to handle the UI state that reacts to user inputs or other changes, and they ensure your UI updates correctly when the state changes. Here's how you can manage local variables in Compose:
//
//### Using `remember`
//The `remember` function is used to preserve data across recompositions. It keeps data until the composable that uses it gets removed from the composition or until its key changes (if a key is provided). Without `remember`, the variable would be re-initialized with every recomposition, which typically isn't desirable for stateful data.
//
//Here’s a simple example:
//
//```kotlin
//@Composable
//fun Counter() {
//    var count by remember { mutableStateOf(0) }
//
//    Button(onClick = { count++ }) {
//        Text("Count: $count")
//    }
//}
//```
//
//In this example, `count` is a local variable that stores the state of a counter. `remember` ensures that the count value is preserved across recompositions, and `mutableStateOf` provides a mutable state backed by Compose's state system which triggers a recomposition when the state changes.
//
//### Using `rememberSaveable`
//`rememberSaveable` is similar to `remember`, but it additionally preserves state across configuration changes (like screen rotations) or process death and recreation in Android.
//
//```kotlin
//@Composable
//fun PersistentCounter() {
//    var count by rememberSaveable { mutableStateOf(0) }
//
//    Button(onClick = { count++ }) {
//        Text("Count: $count")
//    }
//}
//```
//
//This example works similarly to the first, but if the device orientation changes or the process is killed by the system and later recreated, the `count` variable's state will be restored.
//
//### Using state in more complex scenarios
//For more complex scenarios, you might use custom classes or collections. When doing so, you should ensure the state is handled appropriately to be recomposition-friendly:
//
//```kotlin
//@Composable
//fun TodoList() {
//    var todos by remember { mutableStateOf(listOf("Learn Compose", "Build Apps")) }
//
//    Column {
//        for (todo in todos) {
//            Text(todo)
//        }
//        Button(onClick = { todos = todos + "New Task" }) {
//            Text("Add Task")
//        }
//    }
//}
//```
//
//### Best Practices
//- **Minimal state**: Only use `remember` and `mutableStateOf` for data that needs to trigger UI updates. This minimizes unnecessary recompositions.
//- **Scoping**: Keep your state as close as possible to where it's used to make your composables easier to understand and reuse.
//- **Immutability**: Favor using immutable or read-only data structures when possible, modifying state by creating new instances (like in the Todo list example).
//
//By following these practices, you can effectively manage local variables and state in your Compose UIs, ensuring they remain performant and maintainable.
//
//