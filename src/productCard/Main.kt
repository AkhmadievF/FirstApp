package productCard

fun main() {
//    val shoesCard = ShoesCard("Sneakers", "Nike", 3000, 42.5f)
//    shoesCard.printInfo()
    val assistant = Assistant("Helen")
    val consultant = Consultant("Nick",30)
    val director = Director("Andrey", 30)
    val accountant = Accountant("Chris", 34)
    val employees = listOf<Worker>(director,consultant,assistant, accountant)
    for (employee in employees){
        employee.work()


    }
}
