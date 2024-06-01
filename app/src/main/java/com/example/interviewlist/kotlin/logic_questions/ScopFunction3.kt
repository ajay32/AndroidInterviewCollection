package com.example.interviewlist.kotlin.logic_questions

data class Device(var isOnline: Boolean, var status: String)
fun checkDevice(device: Device) {
    with(device) {
        isOnline = true
        status = "Active"
    }
    device.apply {
        isOnline = false
        status = "Inactive"
    }
    println(device)
}

//Question: How do the use of with and apply affect the device object's final state? What is printed?

// output -> Device(isOnline=false, status=Inactive)