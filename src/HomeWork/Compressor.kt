package HomeWork

class Compressor(processorName: String="compressed_") : DataProcessor(processorName), Transformable {
    override fun process(data: String): String {
        return "Обработчик: Compressor обработал данные"
    }

    override fun transform(data: String): String {
        return "Compressor преобразовал данные:$processorName$data "
    }
}