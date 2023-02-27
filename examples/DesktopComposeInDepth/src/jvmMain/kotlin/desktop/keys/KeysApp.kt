package desktop.keys

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import desktop.model.Department.*
import desktop.model.Employee
import desktop.util.Rule

@Composable
fun EmployeeBox(employee: Employee, key: String?) {
    val keyInfo = if(key == null) "(no key)" else "(key=$key)"
    println("[Re]composing ${employee.name} $keyInfo")

    Row { Text(employee.toString()) }
}

@Composable
fun KeysApp() {
    val staff = remember { mutableStateListOf(
        Employee("AB12", "Dave", IT),
        Employee("CD34", "Jane", HR),
        Employee("EF56", "Pete", Sales),
        Employee("GH78", "Mary", IT),
        Employee("IJ90", "Fred", HR)
    ) }

    Column {
        staff.forEach { EmployeeBox(it, null) }
        Rule()

        staff.forEach {
            key(it.id) {
                EmployeeBox(it, it.id)
            }
        }
        Rule()

        Row {
            Button(onClick = {
                println("Adding an employee at the top")
                staff.add(0, Employee("WX67", "Homer", IT))
            }) {
                Text("Add Employee At Top")
            }
        }
        Row {
            Button(onClick = {
                println("Adding an employee at the bottom")
                staff.add(Employee("YZ89", "Marge", HR))
            }) {
                Text("Add Employee At Bottom")
            }
        }
    }
}