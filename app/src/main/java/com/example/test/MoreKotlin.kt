package com.example.test

class MoreKotlin {
}

fun main() {
    /*Quiz().printProgressBar()
    val quiz = Quiz().printQuiz()*/
    val list = mutableListOf("first", "second", "third")
    println(list[0])
    println(list[0])
    println(list.size)
    println(list.indexOf("third"))
    list.add("guvno")
    list.remove("guvno")
    for (value in list) {
        println(value)
    }
    println(list.contains("first"))
    val solar = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )
    solar["Pluto"] = 5
    solar.remove("Pluto")
    for (mutableEntry in solar) {
        print(mutableEntry.value)
        print(mutableEntry.key)
        println(mutableEntry)
    }
}
class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    override val progressText: String
        get() = "${answered} of ${total} answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }
    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
            println()
        }
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
            println()

        }
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
            println()
        }
    }
}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}
