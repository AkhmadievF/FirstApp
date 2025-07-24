package productCard

import java.io.File

class Accountant(
    id: Int,
    name: String,
    age: Int,
    salary:Int) : Worker(id, name, age, salary, positionCode = PositionCode.ACCOUNTANT), Cleaner, Supplier {
    private val workersRepository = WorkersRepository()
    val items = mutableListOf<ProductCard>()
    val productTypes = ProductTypes.entries
    val operationCode = OperationCode.entries
    val file = File("ProductCards")


    override fun work() {
        while (true) {
            println("Enter the operation code.")
            for ((index, code) in operationCode.withIndex()) {
                println(" $index - ${code.title}")
            }
//            print("\b:")
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

                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_AN_EMPLOYEE -> fireAnEmployee()
                OperationCode.SHOW_ALL_EMPLOYEE -> showAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
            }

        }

    }
    fun changeSalary(){
        println("Enter the id: ")
        val id = readln().toInt()
        println("Enter new salary: ")
        val salary = readln().toInt()
        workersRepository.changeSalary(id, salary)
    }
    fun removeProductCard() {
        val itemsInArray: MutableList<ProductCard> = loadAllCards()
        println("Enter the name of card: ")
        val nameOfCard = readln()
        for (card in itemsInArray) {
            itemsInArray.remove(card)
            break
        }
        file.writeText("")
        for (card in itemsInArray) {
            saveProductCardToFile(card)
        }
    }

    private fun loadAllCards(): MutableList<ProductCard> {
        val itemsInArray = mutableListOf<ProductCard>()
        val items = file.readText()
        if (items.isEmpty()) {
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

    fun saveProductCardToFile(productCard: ProductCard) {
        file.appendText("${productCard.name}%")
        file.appendText("${productCard.brand}%")
        file.appendText("${productCard.price}%")
        if (productCard is FoodCard) {
            val caloric = productCard.caloric
            file.appendText("$caloric%${ProductTypes.FOOD}\n")
        } else if (productCard is ApplianceCard) {
            val wattage = productCard.wattage
            file.appendText("$wattage%${ProductTypes.APPLIANCE}\n")
        } else if (productCard is ShoesCard) {
            val size = productCard.size
            file.appendText("$size%${ProductTypes.SHOE}\n")
        }

    }

    private fun showInfo() {
        val item = file.readText()
        if (item.isEmpty()) {
            return
        }
        val products = item.trim().split("\n")
        for (product in products) {
            val itemArray = product.split("%")
            val name = itemArray[0]
            val brand = itemArray[1]
            val price = itemArray[2]
            val type = itemArray.last()
            val productType = ProductTypes.valueOf(type)
            val productCard = when (productType) {
                ProductTypes.FOOD -> {
                    val caloric = itemArray[3].toInt()
                    FoodCard(name, brand, price.toInt(), caloric)
                }
                ProductTypes.APPLIANCE -> {
                    ApplianceCard(name, brand, price.toInt(), itemArray[3].toInt())
                }
                ProductTypes.SHOE -> {
                    ShoesCard(name, brand, price.toInt(), itemArray[3].toFloat())
                }
            }
            productCard.printInfo()
        }

    }

    private fun registerNewEmployee() {
        val  positions = PositionCode.entries
        print("Choose position ")
        for ((type, index) in positions.withIndex()) {
            print("$type - ${index.title},")
        }
        println("\b:")
        val postionIndex = readln().toInt()
        val position = positions[postionIndex]

        val id = enterId()
        val name = enterNameWorker()
        val age = enterAge()
        println("Enter salary: ")
        val salary = readln().toInt()
        val worker = when(position){
            PositionCode.DIRECTOR -> Director(id, name, age, salary)
            PositionCode.ACCOUNTANT -> Accountant(id, name, age, salary)
            PositionCode.ASSISTANT ->Assistant(id, name, age, salary)
            PositionCode.CONSULTANT -> Consultant(id, name, age, salary)
        }
        workersRepository.registerNewEmployee(worker)
    }


    private fun showAllEmployees() {
        val workers = workersRepository.loadAllEmployees()
        for (worker in workers){
            worker.printInfoEmployee()
        }
    }

    private fun fireAnEmployee() {
        println("Enter the id: ")
        val id = readln().toInt()
        workersRepository.fireAnEmployee(id)
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
    private fun enterId(): Int {
        print("Enter id: ")
        return readln().toInt()
    }

    private fun enterNameWorker(): String {
        print("Enter the name: ")
        return readln()
    }

    private fun enterAge(): Int {
        print("Enter age: ")
        return readln().toInt()
    }

    override fun clean() {
        println("Accountant $name is cleaning workplace. . .")
    }
    override fun buyThing() {
        println("Accountant $name is buying things. . .")
    }
}