package com.example.interviewlist.kotlin.jetpackcompose

//`CompositionLocal` in Jetpack Compose is a powerful feature designed to pass data down the composition tree implicitly, without having to manually pass props to each composable function. This is particularly useful for providing common configuration or dependencies deep into the component hierarchy without cluttering the component interfaces.
//
//### What is CompositionLocal?
//CompositionLocal allows you to provide values that can be consumed by any child composable without being explicitly passed through all layers of the component hierarchy. It is similar to "context" in other UI frameworks like React's Context API.
//
//### Use Cases for CompositionLocal
//CompositionLocal is often used for:
//- Theme data (like colors, typography, dimensions)
//- Localization resources
//- Access to common functionality like DAOs or network clients
//- Environment configurations (like API keys)
//
//### Advantages of CompositionLocal
//1. **Decouples Composables from their Environment**: Composables don’t need to have environment parameters passed down through every layer, reducing boilerplate and making them more reusable.
//2. **Scoped Provisioning**: Values can be scoped to particular parts of the UI tree, allowing different parts of your app to have different configurations of the same type of data.
//3. **Efficient Updates**: If a CompositionLocal’s value changes, only the composables that consume that value are recomposed.
//
//### How to Use CompositionLocal
//Using CompositionLocal involves two main steps: defining a CompositionLocal and providing a value for it.
//
//#### Step 1: Define a CompositionLocal
//You define a `CompositionLocal` using `compositionLocalOf` or `staticCompositionLocalOf`. The latter is used when you don't need a default value.
//
//```kotlin
//val LocalAppColor = compositionLocalOf { Color.Black }
//```
//
//#### Step 2: Provide a Value
//You provide a value to the CompositionLocal using the `CompositionLocalProvider`. This is typically done near the top of your component tree, or at the root of a particular subtree that needs a specific configuration.
//
//```kotlin
//CompositionLocalProvider(LocalAppColor provides Color.Red) {
//    // Your composables here can access LocalAppColor, which will be Color.Red
//}
//```
//
//#### Step 3: Access the Value
//Anywhere within the subtree where the value is provided, you can access the current value of a `CompositionLocal` using `.current`.
//
//```kotlin
//@Composable
//fun MyComposable() {
//    val color = LocalAppColor.current
//    Text("Hello, World!", color = color)
//}
//```
//
//### Best Practices
//While `CompositionLocal` is very powerful, it should be used judiciously:
//- **Avoid Overuse**: Rely on `CompositionLocal` only for truly global needs or configurations that need to be accessed by many composables.
//- **Maintain Transparency**: Keep the use of `CompositionLocal` transparent by documenting its uses and ensuring that it is not used to implicitly pass down props that should be explicit.
//
//### Conclusion
//`CompositionLocal` provides a mechanism to pass data through the composable tree implicitly, aiding in reducing boilerplate and making composables cleaner and more focused on their display logic. However, it should be used with care to avoid creating hidden dependencies and making the data flow in your application hard to follow.
//


//==================================== staticComposableLocalOf

//`staticCompositionLocalOf` is a function in Jetpack Compose used to create a `CompositionLocal`, which is similar to `compositionLocalOf` but specifically for cases where you don't require a default value. It's useful for creating `CompositionLocal` instances that will always be provided with a value before being accessed, ensuring that your application's composition does not rely on possibly undefined defaults.
//
//### When to Use `staticCompositionLocalOf`
//You should use `staticCompositionLocalOf` when:
//- You are sure that the `CompositionLocal` will always be provided with a value in the composition before any composable tries to consume it.
//- You want to avoid providing a default value that might be inappropriate or misleading, which could lead to hard-to-detect bugs if the `CompositionLocal` is accessed without being properly provided.
//
//This approach encourages developers to be explicit about the dependency provision and helps to ensure that all required dependencies are properly set up.
//
//### Example of Using `staticCompositionLocalOf`
//Let's look at an example where we might use `staticCompositionLocalOf` for dependency injection, such as providing a ViewModel or some other object that should not have a default and must be provided by the parent composable.
//
//#### Step 1: Define a `CompositionLocal`
//First, define the `CompositionLocal` without a default value using `staticCompositionLocalOf`.
//
//```kotlin
//import androidx.compose.runtime.staticCompositionLocalOf
//import androidx.lifecycle.ViewModel
//
//val LocalViewModel = staticCompositionLocalOf<ViewModel> {
//    // An explicit error is thrown because no default value is provided
//    error("No ViewModel provided")
//}
//```
//
//#### Step 2: Provide a Value
//Next, you provide the `CompositionLocal` at a higher level in your composition where the `ViewModel` is available.
//
//```kotlin
//@Composable
//fun App(viewModel: ViewModel) {
//    CompositionLocalProvider(LocalViewModel provides viewModel) {
//        // Your composables here can now access LocalViewModel
//        ScreenContent()
//    }
//}
//```
//
//#### Step 3: Access the Value
//Consuming composables can now access the `ViewModel` via `LocalViewModel` assured that it has been provided.
//
//```kotlin
//@Composable
//fun UserDetails() {
//    val viewModel = LocalViewModel.current
//    // Use viewModel here
//}
//```
//
//### Benefits of `staticCompositionLocalOf`
//1. **Safety**: By forcing a provider to be set, it avoids the use of inappropriate defaults which can make debugging difficult when a default value is not meaningful.
//2. **Clear Dependencies**: It makes the dependencies of your components explicit, which improves readability and maintainability of your code.
//3. **Enforces Good Practices**: Since it requires a value to be provided, it encourages a good architectural pattern where dependency injection and provision are consciously designed.
//
//### Conclusion
//Using `staticCompositionLocalOf` helps maintain clear and safe coding practices by ensuring that all composables have the dependencies they require provided explicitly. This tool is particularly useful in large applications with complex dependency trees and when using architecture patterns that emphasize explicit dependency management, like clean architecture or certain forms of dependency injection.
//

