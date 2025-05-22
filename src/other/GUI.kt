package other

fun main() {
    val c = readln().split(" ")
    val monster = Monster(c[0].toInt(),c[1].toInt(),c[2].toInt(),c[3].toInt(),c[4].toInt())
    monster.printInfo()

}