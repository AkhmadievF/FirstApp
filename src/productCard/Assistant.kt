package productCard

class Assistant(
    id: Int,
    name: String,
    age:Int,
    ): Worker(id, name, age, positionCode = PositionCode.ASSISTANT), Cleaner, Supplier {

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
    override fun work(){
        println("Assistant $name answering phone...")
    }

    override fun clean() {
        println("Assistant $name is cleaning workplace . . .")
    }

    override fun buyThing() {
        println("Assistant $name is buying things. . .")
    }

}