package com.example.interviewlist.solid.kotlin.srp_ocp

// its managing users so not violation SRP
// not violation OCP
// LSP does not apply here not subclasses
// ISP does not apply here
// DIP does not appy here it is not interfacting with DB or external service
class UserManager {
    var users: MutableList<String> = mutableListOf() // encapsulation violation its public

    fun addUser(user: String) {
        if (!users.contains(user)) {
            users.add(user)
        }
    }

    // ... other methods ...
}

// fix version of the class you can find below

class UserManager1 {
    private val users: MutableList<String> = mutableListOf()

    fun addUser(user: String) {
        if (!users.contains(user)) {
            users.add(user)
        }
    }

    fun getUsers(): List<String> {
        return users.toList()
    }

    // ... other methods ...
}
