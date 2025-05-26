package orders

fun main() {
    val order1 = Order(0, "completed", "electronics")
    val order2 = Order(0, "processing", "furniture")
    val order3 = Order(0, "canceled", "electronics")
    val order4 = Order(0, "completed", "electronics")
    val order5 = Order(0, "completed", "furniture")

    val listOrder = listOf(order1,order2,order3,order4,order5)
    val mutableList = removeCompletedOrders(listOrder, "electronics")
        println(mutableList)

}