package productCard

import kotlin.random.Random

class Consultant(
    id: Int,
   name: String,
   age:Int
): Worker(id, name, age, positionCode = PositionCode.CONSULTANT), Cleaner {
    fun sayHello(){
        print("Hi! My name is $name.")
        if (age>0){
            println("I am $age age old")
        }

    }
    fun costumerClient(){
        val rand = Random.nextInt(1, 100)
        repeat(rand) {
            print("The costumer is served...")
        }
        println("\n${name} served $rand client")
    }

    override fun clean() {
        println("Consultant $name is cleaning workplace . . .")
    }
}