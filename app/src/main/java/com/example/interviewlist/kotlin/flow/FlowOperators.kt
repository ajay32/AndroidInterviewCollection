package com.example.interviewlist.kotlin.flow

//Kotlin Flow provides a rich set of operators that can be used to transform, filter, combine, and control the flow of data in reactive programming. These operators make it possible to compose complex data processing pipelines that are easy to read and maintain. Here's an overview of the most commonly used operators in Kotlin Flow:
//
//### Transforming Operators
//
//- **`map`**: Transforms each value of the flow into another value using a given function.
//- **`transform`**: More general than `map`. Allows emitting multiple values for each input value.
//- **`flatMapConcat`**: Transforms each element into a new flow, then flattens these flows into a single flow sequentially.
//- **`flatMapMerge`**: Similar to `flatMapConcat`, but collects the results concurrently.
//- **`flatMapLatest`**: When a new value is emitted, the previous flow of values is cancelled and the new flow is collected.
//
//### Filtering Operators
//
//- **`filter`**: Emits only those values that satisfy a given predicate.
//- **`filterNot`**: Emits values that do not satisfy the provided predicate.
//- **`filterNotNull`**: Emits only non-null values.
//- **`take`**: Takes the first n values from the flow, then cancels the flow's collection.
//- **`drop`**: Skips the first n values and emits the rest.
//
//### Terminal Operators
//
//- **`toList`**, **`toSet`**: Collects the flow into a List or Set.
//- **`first`**, **`last`**: Returns the first or last element of the flow, respectively.
//- **`single`**: Expects the flow to emit exactly one element.
//- **`reduce`**, **`fold`**: These aggregate the flow values into a single value by sequentially applying an operation.
//
//### Combining Operators
//
//- **`zip`**: Combines the corresponding values of two flows using a provided function.
//- **`combine`**: Combines the latest values of two or more flows using a provided function whenever any of the flow emits a value.
//- **`flattenMerge`**: Flattens a Flow of Flows into a single Flow, collecting up to a specified number of concurrent flows.
//- **`merge`**: Merges multiple flows into a single flow.
//
//### Error Handling
//
//- **`catch`**: Catches exceptions in the flow completion and can emit a value or complete the flow when an exception occurs.
//- **`onEach`**: Performs an action on each value emitted by the flow before passing it downstream.
//- **`onCompletion`**: Invokes a specified action after the flow collection completes, successfully or not.
//
//### Context Preservation
//
//- **`flowOn`**: Specifies the CoroutineContext to run the flow operations on.
//- **`buffer`**: Allows the flow to buffer emissions, potentially running producers and consumers in different coroutines for efficiency.
//- **`conflate`**: Skips intermediate values when the collector is slower than the producer.
//- **`collectLatest`**: Cancels the previous collection invocation when a new value is emitted.
//
//### Utility Operators
//
//- **`onStart`**: Invokes an action before the flow starts collecting.
//- **`onEach`**: Invokes a specified action each time the flow emits a value.
//- **`onEmpty`**: Invokes an action if the flow completes without emitting any values.
//- **`retry`**: Retries collecting the flow after an exception based on a predicate or a fixed number of attempts.
//- **`retryWhen`**: Retries collecting the flow when an exception occurs based on a dynamic condition.
//
//These operators can be combined and nested to create complex data-processing and reactive logic. They are crucial for efficiently handling asynchronous data streams in applications, especially when dealing with UIs, network calls, or any other asynchronous operations.
//
//

//=================================