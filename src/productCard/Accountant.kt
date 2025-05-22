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
                        println(item)
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
            when {
                itemArray.contains("FOOD") -> {
                    items.add(FoodCard(itemArray[0], itemArray[1], itemArray[2].toInt(), itemArray[3].toInt()))
                }
                itemArray.contains("SHOE") -> {
                    items.add(ShoesCard(itemArray[0], itemArray[1], itemArray[2].toInt(), itemArray[3].toFloat()))
                }
                itemArray.contains("APPLIANCE") -> {
                    items.add(ApplianceCard(itemArray[0], itemArray[1], itemArray[2].toInt(), itemArray[3].toInt()))
                }
            }
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