package other

fun main() {
    val weight = readln().toInt()
    var price = 0
    when (weight) {
        in 0..<2 -> {
            price = 150
        }
        in 2..<5 -> {
            price = 200
            println("$price  руб./км.")
        }
        in 5..<12 -> {
            price = 250
            println("$price  руб./км.")
        }
        in 12..<18 -> {
            price = 300
            println("$price  руб./км.")
        }
        in 18..<30 -> {
            price = 350
            println("$price  руб./км.")
        }

        in 30..<200 -> {
            price = 1000
            println("$price  руб./км.")
        }

        else -> {
            println("Для расчета стоимости свяжитесь с менеджером.")
        }
    }

}