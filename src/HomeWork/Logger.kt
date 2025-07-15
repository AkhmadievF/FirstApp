package HomeWork

class Logger(processorName: String = "") : DataProcessor(processorName) {
    override fun process(data: String): String {
        return "Обработчик: Logger обработал данные"
    }
}