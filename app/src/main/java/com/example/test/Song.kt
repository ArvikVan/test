package com.example.test
fun main() {
    val brunoSong = Song("We Don't Talk About Bruno", "Encanto Cast", 2022, 1_000_000)
    brunoSong.printDescription()
    println(brunoSong.isPopular)
}
class Song(
    private val title : String,
    private val artist : String,
    private val published : Int,
    private val count : Int
) {
    val isPopular : Boolean
        get() = count >= 1000
    fun printDescription() {
        println("$title, performed by $artist, was released in $published.")
    }
}