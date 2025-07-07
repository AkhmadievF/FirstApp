package productCard

class Director(
    id: Int,
    name: String,
    age: Int): Worker(id, name, age) {
    fun takeCoffee(assistant: Assistant, coffeeType: String){
        assistant.bringCoffee(1,coffeeType)
        println("Thank you ${assistant.name}. $coffeeType is very tasty!")
    }
    fun forceConsul(consultant: Consultant){
        consultant.costumerClient()
    }

    override fun work() {
        println("I am drinking coffee...")
    }
}