package com.example.interviewlist.androidtopics

//In Android development, the concept of **Context** is fundamental as it allows access to application-specific resources and classes as well as up-calls for application-level operations such as launching activities, broadcasting, and receiving intents. It's essentially the handle to the system; your app's way of communicating with the Android system.
//
//### Types of Context
//
//1. **Context**: This is an abstract class whose implementation is provided by the Android system. It encapsulates information about the application environment and provides the interface to system resources (like resolving resources, obtaining access to databases and preferences, etc.). Context is a superclass for both Activity and Service contexts.
//
//2. **Application Context**: This is a singleton instance that is maintained across the entire lifecycle of your application. It can be accessed in any activity through `getApplicationContext()`. This context is tied to the lifecycle of the application and is suitable for use where you need a context whose lifecycle is separate from the current context or when you are passing a context beyond the scope of an activity.
//
//### Differences
//
//- **Activity Context**: This context is available in an activity. This is tied to the lifecycle of an activity and can potentially lead to memory leaks if used improperly, e.g., kept around after the activity needs to be garbage collected. Thus, this should be used when you are passing the context in the scope of an activity which will be used in elements or operations started from this activity.
//
//- **Application Context**: Since it's tied to the application's lifecycle, it doesn't represent any UI operations. Using the application context everywhere can avoid memory leaks, particularly when you need a context for long-lived operations, independent of the activities' lifecycle.
//
//### Practical Example
//
//Consider a scenario where you need to create a singleton class for your application to manage network requests or database operations. Since these operations are not tied to any specific activity and are needed throughout the lifetime of your application, you should use Application Context.
//

//public class NetworkManager {
//    private static NetworkManager instance;
//    private Context context;
//
//    private NetworkManager(Context context) {
//        // Use application context to prevent leaking activity context.
//        this.context = context.getApplicationContext();
//    }
//
//    public static synchronized NetworkManager getInstance(Context context) {
//        if (instance == null) {
//            instance = new NetworkManager(context);
//        }
//        return instance;
//    }
//
//    // Method to perform network operations
//    public void fetchData() {
//        // use context to access network systems, etc.
//    }
//}

//
//### When to Use Each
//
//- **Use Activity Context** when you need a context that is themed or when you are working with components that will need to be used in the context of an activity or require the activity context (like dialogs, layout inflaters).
//- **Use Application Context** in situations where you need a context for object lifespan or operations that extend beyond the visibility of a single activity or when you are passing the context outside the activity that created it to avoid unintentional references (avoiding memory leaks).
//
//Understanding and using the appropriate type of context in Android applications is crucial for efficient memory management and functionality. Always think about the scope of the context you need based on the operations you are performing.
//
//