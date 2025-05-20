package productCard

import kotlin.random.Random

class Consultant(
   name: String,
   age:Int = 0
): Worker(name, age) {
    fun sayHello(){
        print("Hi! My name is $name.")
        if (age>0){
            println("I am $age age old")
        }

    }

    override fun work() {
        val rand = Random.nextInt(1, 100)
        repeat(rand) {
            print("The costumer is served...")
        }
        println("\n${name} served $rand client")
    }
}