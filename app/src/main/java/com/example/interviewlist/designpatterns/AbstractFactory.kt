package com.example.interviewlist.designpatterns

//The Abstract Factory Pattern is an extension of the basic Factory pattern. It involves using a super-factory which creates other factories. This pattern is particularly useful when there is a need to create families of related or dependent objects without specifying their concrete classes.
//
//In Kotlin, implementing the Abstract Factory pattern typically involves defining an interface for each type of factory. Each interface then has one or more methods that create a new object. The factories that implement these interfaces create objects of specific classes that extend or implement the abstracted or interfaced types.
//
//### Example: UI Component Factory
//
//Imagine you are developing an application that needs to adapt to different themes, like a Light Theme and a Dark Theme. Each theme has different types of UI components like Buttons and TextFields. You can use the Abstract Factory Pattern to solve this problem efficiently.
//
//#### Step 1: Define Abstract Products
//
//These are interfaces or abstract classes representing individual types of products that are part of the theme.


interface Button {
    fun paint()
}

interface TextField {
    fun input()
}

//
//#### Step 2: Create Concrete Products
//
//Implement these interfaces for each specific theme.


class LightButton : Button {
    override fun paint() {
        println("Rendering button in light theme")
    }
}

class DarkButton : Button {
    override fun paint() {
        println("Rendering button in dark theme")
    }
}

class LightTextField : TextField {
    override fun input() {
        println("Input field in light theme")
    }
}

class DarkTextField : TextField {
    override fun input() {
        println("Input field in dark theme")
    }
}


//#### Step 3: Define Abstract Factory

//This interface declares a set of methods for creating each kind of product.


interface GUIFactory {
    fun createButton(): Button
    fun createTextField(): TextField
}


//#### Step 4: Create Concrete Factories

//Implement the factory interface for each theme.


class LightThemeFactory : GUIFactory {
    override fun createButton(): Button = LightButton()
    override fun createTextField(): TextField = LightTextField()
}

class DarkThemeFactory : GUIFactory {
    override fun createButton(): Button = DarkButton()
    override fun createTextField(): TextField = DarkTextField()
}


//#### Step 5: Use the Factory in Your Application

//Depending on the theme settings, your application can use the appropriate factory and produce theme-consistent UI components.


fun configureApplication(theme: String): GUIFactory {
    return when (theme) {
        "dark" -> DarkThemeFactory()
        "light" -> LightThemeFactory()
        else -> throw IllegalArgumentException("Theme not supported")
    }
}

fun main() {
    val currentTheme = "dark" // This could be dynamically set
    val factory = configureApplication(currentTheme)
    val button = factory.createButton()
    val textField = factory.createTextField()

    button.paint()
    textField.input()
}


//### Conclusion
//
//The Abstract Factory Pattern provides a way to encapsulate a group of individual factories with a common goal. It separates the details of implementation of a set of objects from their general usage and relies on object composition, as object creation is implemented in methods exposed in the factory interface.
//
//This pattern is particularly useful in Kotlin when dealing with a system that needs to configure or be compatible with multiple environments. This helps in keeping the system scalable, testable, and manageable.