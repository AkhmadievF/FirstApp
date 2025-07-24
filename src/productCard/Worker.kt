package productCard

import java.awt.Image

open class Worker(
    val id: Int,
    val name: String,
    val age: Int,
    salary:Int,
    val positionCode: PositionCode,
    ) {

    var salary = 15000
        set(value) {
            if (field>value){
                println("new salary is too small...")
            }
            else{
                field = value
            }
        }

    open fun work(){
        println("Worker $name am working...")
    }
    open fun printInfoEmployee(){
        println("id: $id, name is: $name, age is: $age, Position: ${positionCode.title}, Salary: $salary")
    }
}