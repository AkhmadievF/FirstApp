package productCard

enum class OperationCode(val title: String) {
    EXIT("Exit"),
    REGISTER_NEW_ITEM(title = "Register new item"),
    SHOW_INFO("Show information"),
    REMOVE_PRODUCT_CARD("Remove product card"),
    REGISTER_NEW_EMPLOYEE("Register new employee"),
    FIRE_AN_EMPLOYEE("Fire an employee"),
    SHOW_ALL_EMPLOYEE("Show all employees"),
    CHANGE_SALARY("Change salary")
}