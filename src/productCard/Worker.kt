package productCard

import java.awt.Image

open class Worker(
    val id: Int,
    val name: String,
    val age: Int) {
    open fun work(){
        println("I am working...")
    }
}