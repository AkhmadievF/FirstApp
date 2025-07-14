package productCard

class ApplianceCard(
    name: String,
    brand: String,
    price: Int,
    val wattage: Int
): ProductCard(name = name, brand = brand, price = price, productTypes = ProductTypes.APPLIANCE) {
    override fun printInfo() {
        super.printInfo()
        println("Wattage: $wattage")
    }
}