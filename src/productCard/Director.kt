package productCard

class Director(name: String,
    age: Int): Worker(name, age) {
    fun takeCoffee(assistant: Assistant, coffeeType: String){
        assistant.bringCoffee(1,coffeeType)
        println("Thank you ${assistant.name}. $coffeeType is very tasty!")
    }
    fun forceConsul(consultant: Consultant){
        consultant.work()
    }

    override fun work() {
        println("I am drinking coffee...")
    }
}