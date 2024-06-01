package com.example.interviewlist.designpatterns

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.interviewlist.R

//The Factory Pattern is a creational design pattern that provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created. In Kotlin, especially within the context of Android development, the Factory pattern can be very useful for creating instances of a class with a specific configuration or initialization parameters.
//
//### Why Use the Factory Pattern?
//
//1. **Flexibility**: It allows the creation process of objects to be flexible and reusable without coupling the creation logic with the specific classes of objects to be created.
//2. **Separation of Concerns**: It separates the responsibility of instantiating objects from the client that uses the objects. This separation helps manage complexity, especially as applications grow.
//3. **Control Over Instantiation**: It can provide a way to limit or manage the resources by controlling how and when objects are created.
//
//### Implementing the Factory Pattern in Kotlin for Android
//
//Here’s a simple example of how you might implement the Factory pattern in Kotlin for an Android application:
//
//#### Step 1: Define an Interface or Abstract Class
//
//First, you define an interface or an abstract class that describes the contract for your objects.
//
//```kotlin
interface Vehicle {
    fun drive()
}

//
//#### Step 2: Create Concrete Classes
//
//Implement the interface with one or more concrete classes.
//
//```kotlin
class Car : Vehicle {
    override fun drive() {
        println("Drive a car")
    }
}

class Bike : Vehicle {
    override fun drive() {
        println("Ride a bike")
    }
}
//```
//
//#### Step 3: Create the Factory Class
//
//The factory class will have a method that returns instances of the Vehicle type. This method can take a parameter to decide which type of object to create.
//
//```kotlin
class VehicleFactory {
    fun getVehicle(vehicleType: String): Vehicle {
        return when (vehicleType) {
            "Car" -> Car()
            "Bike" -> Bike()
            else -> throw IllegalArgumentException("Unknown vehicle type")
        }
    }
}


//#### Step 4: Use the Factory in Your Application
//
//You can now use the factory to create instances of `Vehicle` without knowing the specifics of the classes that implement `Vehicle`.
//
//```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    setContentView(R.layout.activity_main)

        val factory = VehicleFactory()
        val myVehicle = factory.getVehicle("Car")
        myVehicle.drive()
    }
}


//### Real-World Scenario in Android: ViewModel Factory
//
//A practical application of the Factory pattern in Android development is in creating `ViewModel` instances with specific initial parameters using `ViewModelProvider.Factory`.
//
//Here’s an example of creating a `ViewModel` with a factory:

class MyRepository
class MyViewModel(val repository: MyRepository) : ViewModel() {
    // ViewModel implementation
}

class MyViewModelFactory(private val repository: MyRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return MyViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
}

// Usage in an Activity or Fragment
val factory = MyViewModelFactory(MyRepository())
//val viewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)


//In this example, the `ViewModelFactory` is used to pass a repository to the `ViewModel`, which is a common pattern when the `ViewModel` depends on a repository for data operations.
//
//The Factory pattern, therefore, serves to abstract the process of object creation and helps manage dependencies, which is particularly useful in Android development where managing lifecycles and dependencies can become complex.