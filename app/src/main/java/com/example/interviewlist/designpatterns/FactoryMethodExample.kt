package com.example.interviewlist.designpatterns

//========================
// Factory Method in Kotlin
// meri factory Furniture hai jisme mai table, chair, sofa banata hu its a Furniture. mere pass sunny aati hai bolti hai mje
//char banvani hai ..maine bola bana denge

abstract class Furniture {
    abstract fun description()
}

class Sofa : Furniture() {
    override fun description() {
        println("This is sofa")
    }

}

class Table : Furniture() {
    override fun description() {
        println("This is table")
    }

}

class Chair : Furniture() {
    override fun description() {
        println("This is chair")
    }

}

// pure sheher mai ek hi factory hai meri..or mai theke pe furniture tyar karta hu

object FurnitureFactory {
    fun createFurniture(type: String): Furniture {
        return when(type) {
            "Sofa" -> Sofa()
            "Table" -> Table()
            "Chair" -> Chair()
            else -> throw Exception("Unknown Furniture")
        }

    }

}

fun main() { // sunny ji  she wants a sofa

    val sofa = FurnitureFactory.createFurniture("Sofa")
    sofa.description()

}
