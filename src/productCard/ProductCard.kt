package productCard

open class ProductCard(
    val name: String,
    val brand: String,
    val price: Int,
    val productTypes: ProductTypes) {

    open fun printInfo() {
        print("Name: $name, Brand: $brand, Price: $price, Product type: ${productTypes.title}")
    }
}