package com.example.interviewlist.kotlin

open class Animal(val name: String)
class Lion(name: String) : Animal(name)
class Tiger(name: String) : Animal(name)

interface Container<out T: Animal> {
    fun getAnimal(): T
}

class LionContainer : Container<Lion> {
    override fun getAnimal() = Lion("Leo")
}

class TigerContainer : Container<Tiger> {
    override fun getAnimal() = Tiger("Tigra")
}


fun displayAnimalInEnclosure(container: Container<Animal>) {
    val animal = container.getAnimal()
    println("Displaying ${animal.name}")
}


    fun main() {
        val lionContainer = LionContainer()
        val TigerContainer = TigerContainer()

        displayAnimalInEnclosure(lionContainer)
        displayAnimalInEnclosure(TigerContainer)
    }

/*

Zoo with Different Animal Containers: You're right that the zoo has different enclosures or containers for various animals like lions, tigers, etc.

Enclosure Interface: Each type of animal has its specific enclosure class (like LionContainer for lions, TigerContainer for tigers). These enclosures implement a generic interface Container<T> where T is the type of animal they hold.

Covariance (out Keyword): The key point here is the use of the out keyword in the Container<out T> interface. This means that an Container<Lion> can be treated as an Container<Animal>, and the same goes for Container<Tiger> or any other specific animal enclosure. The out keyword allows this flexibility.

Getting Animals from Enclosures: When you have a function that expects an Container<Animal>, you can pass in an Container<Lion> or Container<Tiger> because of covariance. This function can then call getAnimal() on the enclosure to get an animal without needing to know the specific type of animal it will receive.

Real-World Scenario: In a real-world scenario, this might correspond to a situation where you have a general task to perform with any animal (like displaying them to visitors), and you don't need to know whether it's a lion, a tiger, or any other specific animal. The covariance allows your code to be flexible and work with any type of animal enclosure.

In summary, with covariance in the zoo example, despite having specific enclosures for each type of animal, you can treat all of them as generic animal enclosures when needed, thanks to the out keyword in Kotlin. This provides great flexibility in how you can manage and utilize different animal enclosures in your zoo application.

  */

// In a nutshell aap kisi zoom mai gye or aap bol sake ho mje animal dikaho ..aapko specfic nai bolna padega ki mje lion dikhao ya tiger.. aap sabko animal (generic) treat kar sakte ho ...