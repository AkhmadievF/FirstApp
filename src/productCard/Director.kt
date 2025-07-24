package productCard

class Director(
    id: Int,
    name: String,
    age: Int,
    salary:Int): Worker(id, name, age,salary, positionCode = PositionCode.DIRECTOR), Supplier {
    fun takeCoffee(assistant: Assistant, coffeeType: String){
        assistant.bringCoffee(1,coffeeType)
        println("Thank you ${assistant.name}. $coffeeType is very tasty!")
    }
    fun forceConsul(consultant: Consultant){
        consultant.costumerClient()
    }

    override fun work() {
        println("Director $name  drinking coffee...")
    }

    override fun buyThing() {
        println("Director $name is buying things. . .")
    }
}