package com.example.interviewlist.kotlin


class Elephant(name: String) : Animal(name)
class Rhino(name: String) : Animal(name)

interface Specialist<in T: Animal> { //  write access
    fun treat(animal: T)
}

class GeneralSpecialist : Specialist<Animal> {
    override fun treat(animal: Animal) {
        println("Treating animal: ${animal.name}")
    }
}

class ElephantSpecialist : Specialist<Elephant> {
    override fun treat(animal: Elephant) {
        println("Treating elephant: ${animal.name}")
    }
}

fun treatRhino(specialist: Specialist<Rhino>, rhino: Rhino) {
    specialist.treat(rhino)
}

fun main() {
    val generalSpecialist = GeneralSpecialist()
    val rhino = Rhino("Rex")

    // Using contravariance: GeneralSpecialist can be used as a Specialist<Rhino>
    treatRhino(generalSpecialist, rhino)
}

//Imagine a wildlife rescue center where different specialists treat various animals.
// you can choose a general specialist for the specfic type (Rhino)

// in conveariance people wanted to see the general type Animals
// in Contra people wanted to treat a specific type animal (Rhino)