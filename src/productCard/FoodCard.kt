package productCard

class FoodCard(
    name: String,
    brand: String,
    price: Int,
    val caloric: Int
): ProductCard(name = name, brand = brand, price = price, productTypes = ProductTypes.FOOD) {
    override fun printInfo() {
        super.printInfo()
        println("Caloric: $caloric")
    }
}