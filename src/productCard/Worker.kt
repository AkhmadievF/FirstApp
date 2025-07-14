package productCard

import java.awt.Image

open class Worker(
    val id: Int,
    val name: String,
    val age: Int,
    val positionCode: PositionCode) {
    open fun work(){
        println("I am working...")
    }
    open fun printInfoEmployee(){
        println("id: $id, name is: $name, age is: $age, Position: ${positionCode.title}")
    }
}