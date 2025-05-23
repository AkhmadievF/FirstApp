import java.io.File

class Car(
    val make: String,
    val model: String,
    val year: Int,
    val vin: String,
    val color: String,
) {
    val carAsString = ""

    fun serialize(car: Car): String {
        val carAsString = "${car.make}%" + "${car.model}%" + "${car.year}%" + "${car.vin}%" + car.color
        return carAsString
    }

    fun deserialize(carAsString: String): Car {
        val carItem = carAsString.split("%")
        return Car(
            make = carItem[0],
            model = carItem[1],
            year = carItem[2].toInt(),
            vin = carItem[3],
            color = carItem[4]
        )
    }

}