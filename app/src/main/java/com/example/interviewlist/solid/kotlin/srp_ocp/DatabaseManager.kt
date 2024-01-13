package com.example.interviewlist.solid.kotlin.srp_ocp

// violating SRP
class DatabaseManager {
    private var connection: DatabaseConnection = DatabaseConnection()

    fun connect() {
        // Code to establish a database connection
    }

    fun disconnect() {
        // Code to close the database connection
    }

    fun insertData(data: Data) {
        // Code to insert data into the database
    }

    fun queryData(query: String): Data {
        // Code to retrieve data from the database
        return Data()
    }

    // ... other database operations ...
}

class DatabaseConnection
class Data

//=================== below you may find the fixed version of above

// Manages database connections
class DatabaseConnectionManager { // it will only handle database connection operations
    private var connection: DatabaseConnection = DatabaseConnection()

    fun connect() {
        // Code to establish a database connection
    }

    fun disconnect() {
        // Code to close the database connection
    }

    fun getConnection(): DatabaseConnection { // getter for  Database connection
        return connection
    }
}

// Handles data operations
class DataRepository(private val connectionManager: DatabaseConnectionManager) { // DIP abstraction

    fun insertData(data: Data) {     // this class will handle data operations
        val connection = connectionManager.getConnection()
        // Code to insert data into the database
    }

    fun queryData(query: String): Data {
        val connection = connectionManager.getConnection()
        // Code to retrieve data from the database
        return Data()
    }

    // ... other data operations ...
}

