package HomeWork

class Encryptor(processorName: String = "encoded_"): DataProcessor(processorName), Transformable {
    override fun process(data: String): String {
        return "Обработчик: Encryptor обработал данные"
    }

    override fun transform(data: String): String {
        return "Encryptor преобразовал данные: $processorName$data"
    }
}