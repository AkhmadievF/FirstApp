package profile

class Person(
    private val name: String,
    private var surname:String,
    private val height: Int,
    private val weight: Int
) {
    var age = 0
        set(value) {
            if (value < age) {
                println("can't set new age...")
            } else {
                field = value
            }
        }
        get():Int{
            println("Спрашивать о возрасте неприлично...")
            return field
        }

    fun setSurname(surname: String){
        this.surname = surname
    }
    val getSurnameName: String
        get() {
            return surname + name
        }

}