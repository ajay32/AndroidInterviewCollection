package com.example.interviewlist.designpatterns

fun main() {
    val weatherApp = WeatherApp()

    // register the receiver
    val currenResiter = Display(weatherApp) // registered


    weatherApp.setMesurments(11.0F, 23.0F)

}

// Lets create a Weather App .. so when data changes weather app notify the 10 displays subscribed to it to show data
// display should be subscribed to weather app to get data from it .. subscription mechanish
// 3 things are there Subject ( Weather app) , client (display) , (Observer - clients parent) interface ( that connect both)
// Subject will give data to ObserverInterface (storage) client will get data from ObserverInterface
interface Observer { // will be clients parent
    fun update(temprature : Float, airSpeed : Float)
}
interface Subject {
    fun register(observer : Observer)
    fun remove(observer: Observer)
    fun notifyObservers()
}
;
class WeatherApp : Subject {
    val observerList : MutableList<Observer> = mutableListOf()
    var temprature : Float =  0.0F
    var airSpeed : Float = 0.0F

    override fun register(observer: Observer) { // add it to list
        observerList.add(observer)
    }

    override fun remove(observer: Observer) {
        observerList.remove(observer)
    }

    override fun notifyObservers() {
       for(observer in  observerList) {
           observer.update(temprature, airSpeed)
       }
    }

    fun setMesurments(temp : Float, air : Float) {
        temprature = temp
        airSpeed = air
        notifyObservers()
    }

}

// now Displays have to disply the data

class Display(val weatherApp: WeatherApp) : Observer {

    var temprature : Float =  0.0F
    var airSpeed : Float = 0.0F

    init {
        weatherApp.register(this)
    }
    override fun update(temp: Float, air: Float) {
        temprature = temp
        airSpeed = air
        display()
    }

    fun display() {
        println("WeaTHER DATA $temprature and $airSpeed")
    }

}



// observer design pattern
// subject - WeatherApp
// Client -- displays
// Connector - Observer Interface









