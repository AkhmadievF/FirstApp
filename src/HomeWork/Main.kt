package HomeWork

fun main() {
    val c = readln().split(" ")
    val deliveryObject = DeliveryObject(c[0].toInt(), c[1].toInt(), c[2].toInt(), c[3].toDouble())
    val  warehouse = Warehouse()
   val cargo:Cargo = warehouse.packCargo(deliveryObject)
    cargo.printInfo()
}