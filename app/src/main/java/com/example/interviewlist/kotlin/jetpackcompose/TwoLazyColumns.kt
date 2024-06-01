package com.example.interviewlist.kotlin.jetpackcompose

//In Jetpack Compose, you generally want to avoid having two separate `LazyColumn`s inside a single scrollable container because `LazyColumn` manages its own scrolling and it's designed to lazy load items as they come into the viewport. Placing two `LazyColumn`s inside another scrollable container can interfere with their ability to lazy load content efficiently, potentially causing performance issues.
//
//However, if you need to display two different sets of data sequentially within a single scrollable area, you can consider these approaches:
//
//1. **Single `LazyColumn` with multiple item types:** You can define different item types within a single `LazyColumn`. This approach allows you to handle different types of data or layouts by using conditional rendering inside your `LazyColumn`.
//
//```kotlin
//LazyColumn {
//    items(items = list1) { item ->
//        // Render your first type of item
//    }
//    items(items = list2) { item ->
//        // Render your second type of item
//    }
//}
//```
//
//2. **Nested scrolling:** If for some reason you must nest scrollable components, you can use nested scroll interoperability, but be cautious as it can make your UI less performant and harder to manage.
//
//3. **Merge data sources:** If possible, merge your data into a single list and use a single `LazyColumn`, differentiating the content with item-specific composable functions.
//
//Using a single `LazyColumn` with different sections is usually the most straightforward and performant way to handle multiple data types in a single scrollable area.
//
//