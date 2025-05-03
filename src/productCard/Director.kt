package productCard

class Director(val name: String,
    val age: Int) {
    fun takeCoffee(assistant: Assistant, coffeeType: String){
        assistant.bringCoffee(1,coffeeType)
        println("Thank you ${assistant.name}. $coffeeType is very tasty!")
    }
    fun forceConsul(consultant: Consultant){
        consultant.costumerClient()
    }
}