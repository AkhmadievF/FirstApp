package other

fun main() {
    print("Enter password: ")
    val password = readln().toCharArray()
    val charUuUu = 'Ъ'
    for (pass in password) {
        if (password.contains(charUuUu)) {
            println("У вас идеальный пароль!")
            break
        } else {
            println("Опс! В вашем пароле кое-чего не хватает.")
            break
        }
    }
}