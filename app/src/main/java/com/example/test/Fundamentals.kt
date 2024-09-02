package com.example.test

import kotlin.math.ceil

class Fundamentals {
}
fun main() {
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") {
        celsius -> 9.0 / 5.0 * celsius + 32
    }
    printFinalTemperature(350.0, "Kelvin", "Celsius") {
        kelvins -> kelvins - 273.15
    }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") {
        fahrenheit -> 5.0/9.0  * (fahrenheit - 32) + 273.15
    }
    println(ageColc(60))
}
fun ageColc(age : Int) : Boolean{
    return age in 18..59
}
fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}


/*fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when(age) {
        in 0..12 -> 15
        in 13..60 -> if (isMonday) 25 else 30
        in 60..100 -> 20
        else -> -1
    }
}*/
/*
fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}


fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages >= 100) {
        println("Your phone is blowing up! You have 99+ notifications.")
    } else {
        println("You have $numberOfMessages notifications.")
    }
}*/
