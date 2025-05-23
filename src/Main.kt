import java.io.File

fun main() {
    val carToyota = Car("Toyota", "Corolla", 2011, "JTNBV", "black")
    val carAsString = carToyota.serialize(carToyota)
    println(carAsString)
    println(carToyota.deserialize(carAsString))
}