package hw

import java.text.SimpleDateFormat
import java.util.*

class LogEvent(val eventData: Any) {
    val date: String = getCurrentDate()


    override fun toString(): String {
        return "[$date]: $eventData"
    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return dateFormat.format(Date())
    }
}