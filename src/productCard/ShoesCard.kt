package productCard

class ShoesCard(
    name: String,
    brand: String,
    price: Int,
    val size: Float
): ProductCard(name = name, brand = brand, price = price, productTypes = ProductTypes.SHOE) {
    override fun printInfo() {
        super.printInfo()
        println("Size: $size")
    }
}