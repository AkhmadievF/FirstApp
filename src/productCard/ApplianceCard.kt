package productCard

class ApplianceCard(
    name: String,
    brand: String,
    price: Int,
    val wattage: Int
): ProductCard(name = name, brand = brand, price = price) {
    override fun printInfo() {
        println("Wattage: $wattage")
    }
}