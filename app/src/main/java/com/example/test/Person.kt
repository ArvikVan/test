package com.example.test

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}


class Person(
    private val name: String,
    private val age: Int,
    private val hobby: String?,
    private val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        if (hobby != null) {
            print("Likes to $hobby. ")
        }
        if (referrer == null) {
            println("Doesn't have a referrer. ")
        } else {
            print("Has a referrer named ${referrer.name}, ")
            if (referrer.hobby != null) {
                print("who likes ${referrer.hobby}.")
            } else {
                print("Doesn't have a referrer.")
            }
        }

    }
}