package hw

fun main() {
    val log1 = LogEvent("User logged in")

    val log2 = LogEvent(404)

    val log3 = LogEvent(UserAction.CLICK_BUTTON)
    println(log1)
    println(log2)
    println(log3)
}