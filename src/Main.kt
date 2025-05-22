fun main() {

    val list = listOf<String>(
            "user0",
            "user1",
            "user2",
            "user3",
            "user4",
            "user5",
            "user6",
            "user7",
            "user8",
            "user9")
    task(list)

}
fun task(listUser: List<String>) : List<String> {
    val selectCommand = readln().trim()
    var users = listUser
    val copyListUser = users.toMutableList()

    when(selectCommand){
        "SHOW" -> {
            for (c in copyListUser){
                println(c)
            }
        }
        "ADD" -> {
            val newItem = readln()
            copyListUser.add(newItem)
            for (c in copyListUser){
                println(c)
            }
        }
        "REMOVE" -> {
            val removeItem = readln()
            if (copyListUser.contains(removeItem)){
                copyListUser.remove(removeItem)
            }
            for (c in copyListUser){
                println(c)
            }
        }
        "REMOVE_AT" -> {
            val removeItemForIndex = readln().toInt()
            copyListUser.removeAt(removeItemForIndex)
            for (c in copyListUser){
                println(c)
            }
        }
        else -> {
            println("Некорректное значение")
        }
    }
    users = copyListUser.toList()
        return users
}