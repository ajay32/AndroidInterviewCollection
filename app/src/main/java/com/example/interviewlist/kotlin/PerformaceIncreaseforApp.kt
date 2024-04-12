package com.example.interviewlist.kotlin

//Optimizing the performance of an Android application involves a multi-faceted approach, spanning from design to development, testing, and deployment. Here’s a comprehensive guide on how to enhance the performance of your Android app:
//
//### 1. Efficient Use of Resources
//- **Reduce Memory Usage**: Memory leaks are a common cause of poor performance. Use tools like LeakCanary to detect and fix leaks. Ensure objects are released properly when not in use.
//- **Optimize Layouts**: Simplify your UI by reducing the depth and complexity of view hierarchies. Use `ConstraintLayout` to flatten your UI structure and avoid nested layouts where possible.
//- **Image Management**: Use image sizes appropriate for the required resolution and screen size. Consider using tools like Glide or Coil for efficient loading and caching of images.
//
//### 2. Optimize Application Code
//- **Avoid Blocking the Main Thread**: Any long-running operations, such as network calls or database transactions, should be performed asynchronously. Use Kotlin Coroutines, LiveData, or RxJava for managing background tasks.
//- **Reduce Overdraw**: Overdraw occurs when the UI draws something only to have it completely covered by another drawing layer. Use the developer option “Show overdraw” to detect and minimize overdraw areas.
//- **Use Profiling Tools**: Android Studio's built-in profiler can help you understand where your app might be inefficient in using CPU, memory, network, and energy.
//
//### 3. Efficient Data Handling
//- **Database Optimization**: Use efficient queries and update your database schema to make data access quicker. Consider using Room for a higher-level abstraction over SQLite.
//- **Use Data Binding**: Data Binding can help reduce boilerplate code in your app, which in turn can improve its performance by eliminating unnecessary view lookups.
//- **Manage Data Structures**: Choose the appropriate data structure for your needs. Often, the right choice of data structure can significantly speed up data processing.
//
//### 4. Network Optimization
//- **Reduce Network Calls**: Minimize the number of network requests. Cache server responses when possible to reduce redundant network calls.
//- **Compress Data**: Use GZIP compression for your text-based API responses. For images, consider formats like WebP which provide good quality at lower sizes compared to PNG or JPEG.
//- **Asynchronous Loading**: Load data asynchronously and display it as it arrives, improving user perception of speed.
//
//### 5. Battery Life Considerations
//- **Reduce Wake Locks**: Avoid unnecessary use of wake locks which can drain battery. Instead, use WorkManager for background tasks that can be deferred.
//- **Optimize Location Requests**: Location updates are costly in terms of battery usage. Request updates only when necessary and with appropriate intervals.
//
//### 6. Testing and Monitoring
//- **Regular Testing**: Use unit and integration tests to ensure that changes do not adversely affect performance.
//- **Real-Device Testing**: Test on actual devices with different configurations and operating systems to understand how the app performs under various conditions.
//- **Performance Monitoring**: Use tools like Firebase Performance Monitoring to track your app’s performance in real-time and identify issues experienced by actual users.
//
//### 7. User Interface and Experience
//- **Responsive Animations**: Ensure that UI animations run smoothly. Avoid complex animations that can cause jank and lag.
//- **Progressive Loading**: Implement skeleton screens or content placeholders to improve the perceived performance of your app.
//
//### 8. Code Minimization and Optimization
//- **ProGuard / R8**: Use tools like ProGuard or R8 to minimize and obfuscate your code, which can not only reduce the APK size but also potentially improve runtime performance by optimizing bytecode.
//
//By implementing these strategies, you can significantly enhance the performance of your Android app, leading to a better user experience and potentially higher user retention and satisfaction.
//


//fun add(a: Int, b: Int, addition : () -> Unit) : Int {
//
//    val additionValue = a + b
//    return additionValue
//}
//
//
//fun main() {
//
//    add(2, 3) {
//        println()
//    }
//
//}


fun findTheMaxDuplicateInteger(arr : Array<Int>) : Map<Int, Int> {

    val map = mutableMapOf<Int, Int>()

    for(arrValue in arr) {
        val count = map.getOrDefault(arrValue, 0)

        map[arrValue] = count + 1;
    }

    return map
}

fun main() {

    val myList = arrayOf(1,1,2,3,4,5,5,5,5,6)

    val result = findTheMaxDuplicateInteger(myList)

    println(result)

}





