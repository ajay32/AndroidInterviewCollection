package com.example.interviewlist.androidtopics

//Creating custom views in Android allows you to craft unique UI components that aren't provided out of the box. This process involves subclassing a `View` or an existing view group such as `LinearLayout` or `Button`, and adding specific behaviors and visual appearances. There are generally two types of custom views:
//
//1. **Simple Custom View**: Extends an existing view to enhance functionality.
//2. **Complex Custom View**: Extends `View` directly or an abstract base class to create entirely new types of views.
//
//Here’s how you can create both types of custom views:
//
//### Simple Custom View
//
//For example, let's enhance a `Button` by creating a `CustomButton` that changes its background color when clicked.
//
//```java
//public class CustomButton extends androidx.appcompat.widget.AppCompatButton {
//    private boolean isClicked = false;
//
//    public CustomButton(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//    private void init() {
//        // Initialize some attributes, listeners, etc.
//        setOnClickListener(v -> {
//        isClicked = !isClicked;
//        updateBackground();
//    });
//    }
//
//    private void updateBackground() {
//        if (isClicked) {
//            setBackgroundColor(Color.RED);
//        } else {
//            setBackgroundColor(Color.BLUE);
//        }
//    }
//}
//```
//
//You can now use this `CustomButton` in your XML layouts:
//
//```xml
//<com.yourpackage.CustomButton
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:text="Click me!"/>
//```
//
//### Complex Custom View
//
//For a more complex custom view, let’s create a view that draws a simple circle with a customizable color.
//
//```java
//public class CustomCircleView extends View {
//    private Paint paint;
//    private int circleColor = Color.RED;
//
//    public CustomCircleView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init(attrs);
//    }
//
//    private void init(AttributeSet attrs) {
//        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        paint.setColor(circleColor);
//        // Load attributes
//        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomCircleView);
//        circleColor = a.getColor(R.styleable.CustomCircleView_circleColor, Color.RED);
//        paint.setColor(circleColor);
//        a.recycle();
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        // Draw the circle filling the view
//        int radius = Math.min(getWidth(), getHeight()) / 2;
//        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
//    }
//
//    public void setCircleColor(int newColor) {
//        circleColor = newColor;
//        paint.setColor(circleColor);
//        invalidate(); // Redraw the view with new color
//    }
//}
//```
//
//And corresponding attributes in `res/values/attrs.xml`:
//
//```xml
//<declare-styleable name="CustomCircleView">
//<attr name="circleColor" format="color"/>
//</declare-styleable>
//```
//
//Use this view in your XML layout:
//
//```xml
//<com.yourpackage.CustomCircleView
//android:layout_width="100dp"
//android:layout_height="100dp"
//app:circleColor="#00FF00"/>
//```
//
//### Testing and Use
//
//- **Testing**: Always ensure your custom views handle basic Android lifecycle events and measure/layout passes correctly. Test with different screen sizes and orientations.
//- **Usage**: Use your custom views in your layouts like any other view. Be mindful of performance and overuse, particularly with complex drawing or animations.
//
//By creating custom views, you not only enhance the functionality of your app but also encapsulate specific styling and behavior that can be reused across multiple activities or apps.
//
//
