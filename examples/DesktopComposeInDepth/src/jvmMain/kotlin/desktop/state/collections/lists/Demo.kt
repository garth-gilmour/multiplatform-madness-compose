package desktop.state.collections.lists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import desktop.model.Person
import desktop.util.Rule

@Composable
fun ListStateDemo() {
    val simpsonsList = remember {
        mutableStateOf(
            listOf(
                Person("Homer", 39),
                Person("Marge", 36),
                Person("Bart", 10),
                Person("Liza", 8)
            )
        )
    }

    var flintstonesList = remember {
        mutableListOf(
            Person("Fred", 44),
            Person("Wilma", 43),
            Person("Pebbles", 2)
        )
    }

    Column {
        simpsonsList.value.forEach {
            Row { Text(it.toString()) }
        }
        Rule()

        flintstonesList.forEach {
            Row { Text(it.toString()) }
        }
        Rule()

        Row {
            Button(onClick = {
                simpsonsList.value = simpsonsList.value
                    .drop(1)
                    .plus(Person("Snowball", 3))

                flintstonesList.removeAt(0)
                flintstonesList.add(Person("Dino", 5))
            }) {
                Text("Update Lists")
            }
        }
    }
}