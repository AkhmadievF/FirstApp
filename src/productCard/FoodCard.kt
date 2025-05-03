package productCard

class FoodCard(
    name: String,
    brand: String,
    price: Int,
    val caloric: Int
): ProductCard(name = name, brand = brand, price = price) {
    override fun printInfo() {
        println("Caloric: $caloric")
    }
}