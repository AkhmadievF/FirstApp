package other

class Shape {
    private val length: Int
    private val width: Int

    constructor(length: Int, width: Int) {
        this.length = length
        this.width = width
    }

    constructor() : this(0)

    constructor(size: Int) : this(size, size)

    fun draw() {
        for (i in 0..<this.width) {
            for (j in 0..<this.length) {
                print("* ")
            }
            println()
        }
    }

}