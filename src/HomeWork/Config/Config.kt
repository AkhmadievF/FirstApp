package HomeWork.Config

class Config() {
    var timeout = 30
        set(value) {
            field = if (value in 1..300){
                value
            }else{
                println("Ошибка: Время ожидания должно быть в диапазоне от 1 до 300 секунд. Установлено значение по умолчанию.")
                30
            }
        }
    var maxRetries = 3
        set(value) {
            if (value<0){
                field = 3
                println("Ошибка: Максимальное количество повторных попыток не может быть отрицательным. Установлено значение по умолчанию.")
            } else{
                field = value
            }
        }
    var loggingLevel = LogLevel.INFO
        set(value) {
            if (value==LogLevel.TRACE||value == LogLevel.FATAL){
                println("Ошибка: Уровень ${value.name} недоступен.")
                field = LogLevel.INFO
            } else{
                field = value
            }
        }
    val isDebugMode:Boolean
        get() {
            return loggingLevel == LogLevel.DEBUG
        }
    val isProductionMode:Boolean
        get() {
            return loggingLevel == LogLevel.ERROR
        }
    fun printConfig(){
        println("Время ожидания: $timeout секунд")
        println("Максимальное количество повторных попыток: $maxRetries")
        println("Уровень логирования: $loggingLevel")
        println("Режим отладки: $isDebugMode")
        println("Режим продакшн: $isProductionMode")
    }
}