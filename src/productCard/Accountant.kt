package productCard

class Accountant(
    name: String,
    age: Int
) : Worker(name, age) {

    val productTypes = ProductTypes.entries
    val operationCode = OperationCode.entries

    override fun work() {

            while (true) {
                print("Enter the operation code.")
                for ((index, code) in operationCode.withIndex()){
                    print(" $index - ${code.title},")
                }
                println("\b:")
                val code = readln().toInt()
                if (code == 0) {
                    break
                } else if (code == 1) {

                    print("Enter the product type.")
                    for ((type,index) in productTypes.withIndex()) {
                      print(" $index - $type,")
                    }
                    println("\b:")

                    val index = readln().toInt()
                    val productTypesIndex = productTypes[index]
                    val name = enterName()
                    val brand = enterBrand()
                    val price = enterPrice()
                    when (productTypesIndex) {
                        ProductTypes.FOOD -> {
                            print("Enter the product caloric: ")
                            val caloric = readln().toInt()
                            val foodCard = FoodCard(name, brand, price, caloric)
                            foodCard.printInfo()
                        }

                        ProductTypes.APPLIANCE -> {
                            print("Enter the product wattage: ")
                            val wattage = readln().toInt()
                            val applianceCard = ApplianceCard(name, brand, price, wattage)
                            applianceCard.printInfo()
                        }

                        ProductTypes.SHOE -> {
                            print("Enter the product size: ")
                            val size = readln().toFloat()
                            val shoesCard = ShoesCard(name, brand, price, size)
                            shoesCard.printInfo()
                        }
                    }


                }
                else{
                    break
                }

            }
        }
    }
    private fun enterName(): String {
        print("Enter the product name: ")
        return readln()
    }
    fun enterBrand(): String {
        print("Enter the product brand: ")
        return readln()
    }
    fun enterPrice(): Int {
        print("Enter the product price: ")
        return readln().toInt()
    }