package files

import productCard.OperationCode
import productCard.OperationCode.*
import java.io.File

fun main() {
    val file = File("test.txt")
    val operationCode = OperationCode.entries
    while (true){
        print("select operation code:")
        for ((code, index) in operationCode.withIndex()){
            print(" $index - $code,")
        }
        print("\b:\n")
        val index = readln().toInt()
        val operationIndex = operationCode[index]
        when(operationIndex){
            EXIT -> break
            REGISTER_NEW_ITEM -> {
                print("Enter a new Item: ")
                file.appendText("${readln()}\n")
            }
            SHOW_INFO -> {
                val str = file.readText().trim().split("\n")
                for ((i,s) in str.withIndex()){
                    println("$i - $s")
                }
            }

            REMOVE_PRODUCT_CARD -> TODO()
        }
    }

}