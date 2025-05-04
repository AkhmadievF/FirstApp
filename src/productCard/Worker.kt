package productCard

open class Worker(val name: String,
    val age: Int) {
    open fun work(){
        println("I am working...")
    }
}