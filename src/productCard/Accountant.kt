package productCard

import java.io.File

class Accountant(
    name: String,
    age: Int
) : Worker(name, age) {

    val items = mutableListOf<ProductCard>()
    val productTypes = ProductTypes.entries
    val operationCode = OperationCode.entries
    val positionCode = PositionCode.entries
    val file = File("ProductCards")
    val fileWorker = File("Workers")

    override fun work() {
        while (true) {
            println("Enter the operation code.")
            for ((index, code) in operationCode.withIndex()) {
                println(" $index - ${code.title}")
            }
            //println("\b:")
            val code = readln().toInt()
            val codeIndex = operationCode[code]
            when (codeIndex) {
                OperationCode.EXIT -> {
                    break
                }

                OperationCode.REGISTER_NEW_ITEM -> {
                    registerNewItem()
                }

                OperationCode.SHOW_INFO -> {
                    showInfo()
                }

                OperationCode.REMOVE_PRODUCT_CARD -> {
                    removeProductCard()
                }

                OperationCode.REGISTER_NEW_EMPLOYEE -> {
                    registerNewEmployee()
                }
                OperationCode.FIRE_AN_EMPLOYEE -> TODO()
                OperationCode.SHOW_ALL_EMPLOYEE -> TODO()
            }

        }

    }

    fun removeProductCard() {
        val itemsInArray:MutableList<ProductCard> = loadAllCards()
        println("Enter the name of card: ")
        val nameOfCard = readln()
        for (card in itemsInArray){
            itemsInArray.remove(card)
            break
        }
        file.writeText("")
        for (card in itemsInArray){
            saveProductCardToFile(card)
        }
    }
   private fun loadAllCards(): MutableList<ProductCard> {
        val itemsInArray = mutableListOf<ProductCard>()
        val items = file.readText()
       if (items.isEmpty()){
           return itemsInArray
       }
        val cards = items.trim().split("\n")
        for (card in cards) {
            val elementOfCard = card.trim().split("%")
            val name = elementOfCard[0]
            val brand = elementOfCard[1]
            val price = elementOfCard[2]
            val type = elementOfCard.last()
            val productType = ProductTypes.valueOf(type)
            val productCard = when (productType) {
                ProductTypes.FOOD -> {
                    FoodCard(name, brand, price.toInt(), elementOfCard[3].toInt())
                }

                ProductTypes.APPLIANCE -> {
                    ApplianceCard(name, brand, price.toInt(), elementOfCard[3].toInt())
                }

                ProductTypes.SHOE -> {
                    ShoesCard(name, brand, price.toInt(), elementOfCard[3].toFloat())
                }
            }
            itemsInArray.add(productCard)

        }
        return itemsInArray
    }

    fun saveProductCardToFile(productCard: ProductCard){
        file.appendText("${productCard.name}%")
        file.appendText("${productCard.brand}%")
        file.appendText("${productCard.price}%")
        if (productCard is FoodCard){
            val caloric = productCard.caloric
            file.appendText("$caloric%${ProductTypes.FOOD}\n")
        }
        else if (productCard is ApplianceCard){
            val wattage = productCard.wattage
            file.appendText("$wattage%${ProductTypes.APPLIANCE}\n")
        }
        else if (productCard is ShoesCard){
            val size = productCard.size
            file.appendText("$size%${ProductTypes.SHOE}\n")
        }

    }


    private fun showInfo(){
        val item = file.readText()
        if (item.isEmpty()){
            return
        }
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

    private fun registerNewEmployee() {

        print("Choose position ")
        for ((type, index) in positionCode.withIndex()) {
            print(" ${index.title} - $type,")
        }
        println("\b:")
        val index = readln().toInt()
        val positionCodeIndex = positionCode[index]
        val id = enterId()
        fileWorker.appendText("$id%")
        val name = enterNameWorker()
        fileWorker.appendText("$name%")
        val age = enterAge()
        fileWorker.appendText("$age%")
//        when (positionCodeIndex) {
//            PositionCode.DIRECTOR -> {
//                print("Enter the product caloric: ")
//                val caloric = readln().toInt()
//                fileWorker.appendText("$caloric%")
//            }
//
//            PositionCode.ACCOUNTANT -> {
//                print("Enter the product wattage: ")
//                val wattage = readln().toInt()
//                fileWorker.appendText("$wattage%")
//            }
//
//            PositionCode.ASSISTANT-> {
//                print("Enter the product size: ")
//                val size = readln().toFloat()
//                fileWorker.appendText("$size%")
//            }
//            PositionCode.CONSULTANT -> {
//
//            }

        fileWorker.appendText("$positionCodeIndex\n")

    }
    private fun showAllEmployees(){
        val worker = fileWorker.readText()
        if (worker.isEmpty()){
            return
        }
        val workers = worker.trim().split("\n")
        for (person in workers){
            val itemArray = person.split("%")
            val id = itemArray[0]
            val name = itemArray[1]
            val age = itemArray[2]
            val type = itemArray.last()
            val positionCode = PositionCode.valueOf(type)
            val worker = when(positionCode) {
                PositionCode.DIRECTOR -> {
                    Director(id, name, age)
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

    private fun enterId(): Int{
        print("Enter id: ")
        return readln().toInt()
    }
    private fun enterNameWorker(): String {
        print("Enter the name: ")
        return readln()
    }
    private fun enterAge(): Int{
        print("Enter age: ")
        return readln().toInt()
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
}