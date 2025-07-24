package productCard

import java.io.File

class WorkersRepository {
    val fileWorker = File("Workers")

        fun registerNewEmployee(worker: Worker){
            saveEmployeeToFile(worker)
        }
   private fun saveEmployeeToFile(worker: Worker) {
        fileWorker.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.salary}%${worker.positionCode}\n")
//        if (worker is Director) {
//            fileWorker.appendText("${PositionCode.DIRECTOR}\n")
//        } else if (worker is Accountant) {
//            fileWorker.appendText("${PositionCode.ACCOUNTANT}\n")
//        } else if (worker is Assistant) {
//            fileWorker.appendText("${PositionCode.ASSISTANT}\n")
//        } else if (worker is Consultant) {
//            fileWorker.appendText("${PositionCode.CONSULTANT}\n")
//        }
    }

    fun changeSalary(id:Int, salary:Int){
        val employees = loadAllEmployees()
        fileWorker.writeText("")
        for (employee in employees) {
            if (employee.id == id){
                employee.salary = salary
            }
            saveEmployeeToFile(employee)
        }

    }


    fun loadAllEmployees(): MutableList<Worker> {
        val itemsInArray = mutableListOf<Worker>()
        val items = fileWorker.readText()
        if (items.isEmpty()) {
            return itemsInArray
        }
        val workers = items.trim().split("\n")
        for (person in workers) {
            val itemArray = person.split("%")
            val id = itemArray[0]
            val name = itemArray[1]
            val age = itemArray[2].toInt()
            val salary = itemArray[3].toInt()
            val type = itemArray.last()
            val position = PositionCode.valueOf(type)
            val worker = when (position) {
                PositionCode.DIRECTOR -> {
                    Director(id.toInt(), name, age, salary)
                }
                PositionCode.ACCOUNTANT -> {
                    Accountant(id.toInt(), name, age, salary)
                }
                PositionCode.ASSISTANT -> {
                    Assistant(id.toInt(), name, age,salary)
                }
                PositionCode.CONSULTANT ->{
                    Consultant(id.toInt(), name, age, salary)
                }
            }
            worker.salary = salary
            itemsInArray.add(worker)

        }
        return itemsInArray
    }
    fun fireAnEmployee(id: Int) {
        val itemsInArray: MutableList<Worker> = loadAllEmployees()
        fileWorker.writeText("")
        for (employee in itemsInArray) {
            if (employee.id != id){
                saveEmployeeToFile(employee)
            }

        }
    }
}