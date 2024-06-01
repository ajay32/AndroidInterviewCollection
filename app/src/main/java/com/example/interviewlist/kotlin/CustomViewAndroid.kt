package com.example.interviewlist.kotlin

//Creating a custom view in Android involves extending a base view class and overriding certain methods to define the view’s appearance and behavior. Here’s a step-by-step guide to creating a basic custom view:
//
//### Step 1: Choose a Base Class
//
//Decide which `View` class you want to extend. If your custom view does not need to display anything more complex than what the standard `TextView`, `ImageView`, etc., provide, you can extend one of these. If you need more control, you may extend `View` directly.
//
//### Step 2: Constructors
//
//You need to override constructors in your custom view. There are usually four constructors in a view class, and it's good practice to override all of them:
//
//```kotlin
//class CustomView : View {
//
//    constructor(context: Context) : super(context) {
//        // Custom initialization
//    }
//
//    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
//        // Custom initialization
//    }
//
//    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
//        // Custom initialization
//    }
//
//    // Use this constructor for API 21 and above
//    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
//        // Custom initialization
//    }
//
//    // Custom initialization logic, if needed, can be refactored into a separate method
//}
//```
//
//### Step 3: Overriding `onMeasure()`
//
//The `onMeasure(int, int)` method is where you determine the size requirements for your custom view:
//
//```kotlin
//override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//    super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//
//    // Decide the size of the view
//    val desiredWidth = 200
//    val desiredHeight = 200
//
//    setMeasuredDimension(resolveSize(desiredWidth, widthMeasureSpec), resolveSize(desiredHeight, heightMeasureSpec))
//}
//```
//
//### Step 4: Overriding `onDraw()`
//
//The `onDraw(Canvas)` method is where you draw your view:
//
//```kotlin
//override fun onDraw(canvas: Canvas) {
//    super.onDraw(canvas)
//
//    // Your drawing code here
//    val paint = Paint()
//    paint.color = Color.RED
//    canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
//}
//```
//
//### Step 5: Handling Custom Attributes
//
//If your custom view has custom attributes, define them in `res/values/attrs.xml`:
//
//```xml
//<resources>
//<declare-styleable name="CustomView">
//<attr name="custom_attribute" format="string" />
//</declare-styleable>
//</resources>
//```
//
//Then you can access them in your constructors:
//
//```kotlin
//constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
//    context.theme.obtainStyledAttributes(
//        attrs,
//        R.styleable.CustomView,
//        0, 0
//    ).apply {
//        try {
//            val customAttribute = getString(R.styleable.CustomView_custom_attribute) ?: "Default"
//            // Use customAttribute for something
//        } finally {
//            recycle()
//        }
//    }
//}
//```
//
//### Step 6: Handling User Input
//
//Override `onTouchEvent(MotionEvent)` if your custom view should handle touch events:
//
//```kotlin
//override fun onTouchEvent(event: MotionEvent): Boolean {
//    return when (event.action) {
//        MotionEvent.ACTION_DOWN -> {
//            // Handle touch down
//            true
//        }
//        MotionEvent.ACTION_MOVE -> {
//            // Handle touch move
//            true
//        }
//        MotionEvent.ACTION_UP -> {
//            // Handle touch up
//            true
//        }
//        else -> super.onTouchEvent(event)
//    }
//}
//```
//
//### Step 7: Adding to Layout
//
//Once your custom view is defined, you can add it to your layout XML just like any other view:
//
//```xml
//<com.yourpackage.CustomView
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//app:custom_attribute="Some Value" />
//```
//
//Or, you can add it programmatically:
//
//```kotlin
//val customView = CustomView(context)
//// Customize your view as needed
//layout.addView(customView)
//```
//
//Remember to register any custom attributes in your `R.styleable` so that they can be used in XML layouts.
//
//This is a very basic example of creating a custom view. Depending on what you want your custom view to do, you might need to override other methods, handle saving instance state, or interact with other views in a more complex way.

//fun findTheLongestSubString(s: String) : String { // abcabcbb
//
//    var maxLength = 0
//    var maxSubstring = ""
//    var start = 0
//    var charMap = mutableMapOf<Char, Int>()
//
//    for(str in s.indices) {
//        if(charMap.containsKey(s[str])) {
//            start = maxOf(start, charMap[s[str]]!! +1)
//        }
//        charMap[s[str]] = str
//
//        var maxLength = 0
//        var maxSubstring = ""
//        var start = 0
//        var charMap = mutableMapOf<Char, Int>()
//
//        for(str in s.indices) {
//        if(str - start + 1 > maxLength) {
//            maxLength = str - start + 1
//        }
//        maxSubstring = s.substring(start, str +1)
//    }
//
//    return maxSubstring
//}
//
//fun main() {
//
//
//    println(findTheLongestSubString("abcabcbb"))
//}