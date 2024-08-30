package com.example.test

class FunLambda {
}
fun main() {
    repeat(5) {
        val trickFun = treatOrTrick(true) {
            "$it kakogohuya chto tut proishodit"
        }

    }
    val treatFun = treatOrTrick(false, null)
}
fun treatOrTrick(isTrick : Boolean, extraTreat: ((Int)->String?)?) {
    if (isTrick) {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        trick()
    } else {
        treat()
    }
}
val trick = {
    println("No treats!!!")
}
val treat: () -> Unit = {
    println("Have a treat!!!")
    }