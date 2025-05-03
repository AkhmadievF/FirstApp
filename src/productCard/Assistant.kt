package productCard

class Assistant(val name: String,
    val age:Int = 0) {

    fun bringCoffee(count: Int = 1, coffeeType: String = "Cappuccino"): String{
        repeat(count) {
            println("Get up")
            println("Go to the coffee machine")
            println("Press the \"$coffeeType\" button")
            println("Wait for the $coffeeType prepared")
            println("Take coffee")
            println("Bring coffee to the director")
            println("Put coffee on the table")
            println("Return on the workplace")
        }
        return "Espresso"
    }

}