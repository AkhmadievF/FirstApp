package HomeWork.Config

fun main() {
    val config = Config()
    config.timeout = 150
    config.maxRetries = 5
    config.loggingLevel = LogLevel.ERROR
    config.printConfig()
}