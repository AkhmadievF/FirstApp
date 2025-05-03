fun main() {
    val target = readln().toInt()
    var count = 0
    var result = 0
    while (count<target){
        count++
        result+=count

    }
    println("Сумма чисел от 1 до $target равна $result")

}