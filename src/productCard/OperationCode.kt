package productCard

enum class OperationCode(val title: String) {
    EXIT("Exit"),
    REGISTER_NEW_ITEM(title = "Register new item"),
    SHOW_INFO("Show information"),
    REMOVE_PRODUCT_CARD("Remove product card")
}