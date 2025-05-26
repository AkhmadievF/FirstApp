package orders

import com.sun.java.accessibility.util.EventID

data class Order (
    val id: Int,
    val status: String,
    val type: String
) {
}
    fun removeCompletedOrders (orders: List<Order>, typeToRemove: String): List<Order> {
        val mutableOrder = mutableListOf<Order>()
        for (order in orders){
            if (order.status != "completed"||order.type!=typeToRemove) {
                mutableOrder.add(order)
            }
        }
        return mutableOrder
    }