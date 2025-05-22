package other

fun main() {
    val heavyCar = readln().toBoolean()
    val horsePower = readln().toInt()
    var tax = 0
    var sum = 0
    var carType = ""
    if (!heavyCar){
        carType = "легковой автомобиль"
    }
    else{
        carType = "грузовой автомобиль"
    }
    if (horsePower<=100){
        if (!heavyCar){
         tax = 10
        sum = horsePower*tax
        }
        else {
            tax = 25
            sum = horsePower*tax
        }
    }
    else if (horsePower in 101..150){
        if (!heavyCar) {
            tax = 34
            sum = horsePower * tax
        }
        else {
            tax = 40
            sum = horsePower*tax
        }
    }
    else if (horsePower in 151..200){
        if (!heavyCar) {
            tax = 49
            sum = horsePower * tax
        }
        else {
            tax = 50
            sum = horsePower*tax
        }
    }
    else if (horsePower in 201..250){
        if (!heavyCar) {
            tax = 75
            sum = horsePower * tax
        }
        else {
            tax = 65
            sum = horsePower*tax
        }

    }else if (horsePower>250){
        if (!heavyCar) {
            tax = 150
            sum = horsePower * tax
        }
        else {
            tax = 85
            sum = horsePower*tax
        }
    }
    println("Вид ТС: $carType\nМощность двигателя: $horsePower л.с.\nНалоговая ставка: $tax руб./л.с.\nСумма налога: $sum руб.")

}