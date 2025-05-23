package productCard

import java.io.File

class Accountant(
    name: String,
    age: Int
) : Worker(name, age) {

    val items = mutableListOf<ProductCard>()
    val productTypes = ProductTypes.entries
    val operationCode = OperationCode.entries
    val file = File("ProductCards")

    override fun work() {
        while (true) {
            print("Enter the operation code.")
            for ((index, code) in operationCode.withIndex()) {
                print(" $index - ${code.title},")
            }
            println("\b:")
            val code = readln().toInt()
            val codeIndex = operationCode[code]
            when (codeIndex) {
                OperationCode.EXIT -> {
                    break
                }

                OperationCode.REGISTER_NEW_ITEM ->{
                    registerNewItem()
                }
                OperationCode.SHOW_INFO -> {
                    showInfo()
                }

                OperationCode.SHOW_ITEMS -> {
                    for (item in items){
                        item.printInfo()
                    }
                }
            }

        }

    }
    private fun showInfo(){
        val item = file.readText()
        val products = item.trim().split("\n")
        for (product in products){
            val itemArray = product.split("%")
            val name = itemArray[0]
            val brand = itemArray[1]
            val price = itemArray[2]
            val type = itemArray.last()
            val productType = ProductTypes.valueOf(type)
            val productCard = when(productType) {
                ProductTypes.FOOD -> {
                    FoodCard(name,brand,price.toInt(), itemArray[3].toInt())
                }
                ProductTypes.APPLIANCE -> {
                    ApplianceCard(name,brand,price.toInt(), itemArray[3].toInt())
                }
                ProductTypes.SHOE -> {
                    ShoesCard(name,brand,price.toInt(), itemArray[3].toFloat())
                }
            }
            productCard.printInfo()
        }

    }

    private fun registerNewItem() {

        print("Enter the product type.")
        for ((type, index) in productTypes.withIndex()) {
            print(" $index - $type,")
        }
        println("\b:")
        val index = readln().toInt()
        val productTypesIndex = productTypes[index]
        val name = enterName()
        file.appendText("$name%")
        val brand = enterBrand()
        file.appendText("$brand%")
        val price = enterPrice()
        file.appendText("$price%")
        when (productTypesIndex) {
            ProductTypes.FOOD -> {
                print("Enter the product caloric: ")
                val caloric = readln().toInt()
                file.appendText("$caloric%")
            }

            ProductTypes.APPLIANCE -> {
                print("Enter the product wattage: ")
                val wattage = readln().toInt()
                file.appendText("$wattage%")
            }

            ProductTypes.SHOE -> {
                print("Enter the product size: ")
                val size = readln().toFloat()
                file.appendText("$size%")
            }

        }
        file.appendText("$productTypesIndex\n")

    }
    private fun enterName(): String {
        print("Enter the product name: ")
        return readln()
    }

    private fun enterBrand(): String {
        print("Enter the product brand: ")
        return readln()
    }

    private fun enterPrice(): Int {
        print("Enter the product price: ")
        return readln().toInt()
    }
}