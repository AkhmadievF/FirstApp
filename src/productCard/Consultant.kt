package productCard

import kotlin.random.Random

class Consultant(
    val name: String,
    val age:Int = 0
) {
    fun sayHello(){
        print("Hi! My name is $name.")
        if (age>0){
            println("I am $age age old")
        }

    }
    fun costumerClient(): Int{
        val rand = Random.nextInt(1, 100)
        repeat(rand) {
            print("consume client...")
        }
        return rand
    }
}