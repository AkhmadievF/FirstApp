import kotlin.random.Random

class Monster {
    val pawsCount: Int
    val eyesCount: Int
    val fangsCount: Int
    val clawsCount: Int
    val tentaclesCount: Int

    constructor(pawsCount: Int, eyesCount: Int, fangsCount: Int, clawsCount: Int, tentaclesCount: Int) {
        this.pawsCount = pawsCount
        this.eyesCount = eyesCount
        this.fangsCount = fangsCount
        this.clawsCount = clawsCount
        this.tentaclesCount = tentaclesCount
    }

    constructor(count: Int) : this(count, count, count, count, count)
    constructor() : this(
        Random.nextInt(1, 10),
        Random.nextInt(1, 10),
        Random.nextInt(1, 10),
        Random.nextInt(1, 10),
        Random.nextInt(1, 10)
    )
    fun printInfo(){
        println("Кол-во лап: ${this.pawsCount}\n" +
                "Кол-во глаз: ${this.eyesCount}\n" +
                "Кол-во клыков: ${fangsCount}\n" +
                "Кол-во когтей: ${clawsCount}\n" +
                "Кол-во щупалец: ${tentaclesCount}")
    }


}