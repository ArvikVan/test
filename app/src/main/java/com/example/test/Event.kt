package com.example.test

data class Event (
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val duration: Int
)
enum class Daypart{
    MORNING, AFTERNOON, EVENING
}

val Event.durationOfEvent: String
    get() = if (duration < 60) {
        "short"
    } else {
        "long"
    }
fun main() {
    val event1 = Event(title = "Wake up", description = "Time to get up",  Daypart.MORNING, 0)
    val event2 = Event(title = "Eat breakfast", null, Daypart.MORNING, 15)
    val event3 = Event(title = "Learn about Kotlin",  null, Daypart.AFTERNOON, 30)
    val event4 = Event(title = "Practice Compose", null, Daypart.AFTERNOON, 60)
    val event5 = Event(title = "Watch latest DevBytes video", null,  Daypart.AFTERNOON, 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", null, Daypart.EVENING, 45)
    val events = mutableListOf(event1, event2, event3, event4, event5, event6)
    val shortEvents = events.filter {
        it.duration < 60
    }
    val groupByDaypart = events.groupBy {
        it.daypart
    }
    groupByDaypart.forEach{ (daypart, events) ->
        println("$daypart: ${events.size} events")
    }
    println("Last event of the day: ${events.last().title}")

    println("Duration of first event of the day: ${events[0].durationOfEvent}")
}