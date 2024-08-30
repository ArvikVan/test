package com.example.test
fun main() {
    val newFoldablePhone = FoldablePhone()

    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.foldOff()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
}
open class Phone {
    var isScreenLightOn : Boolean = false
    open fun switchOn() {
        isScreenLightOn = true
    }
    fun switchOff() {
        isScreenLightOn = false
    }
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}
class FoldablePhone: Phone() {
    var isFolded: Boolean = true
    override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        }
    }
    fun fold() {
        isFolded = true
    }
    fun foldOff() {
        isFolded = false
    }
}