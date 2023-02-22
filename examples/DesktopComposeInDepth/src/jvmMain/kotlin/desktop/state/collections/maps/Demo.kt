package desktop.state.collections.maps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import desktop.model.Person
import desktop.util.Rule

@Composable
fun MapStateDemo() {
    val simpsonsMap = remember {
        mutableStateOf(
            mapOf(
                "Homer" to 39,
                "Marge" to 36,
                "Bart" to 10,
                "Liza" to 8
            )
        )
    }

    val flintstonesMap = remember {
        mutableStateMapOf(
            "Fred" to 44,
            "Wilma" to 43,
            "Pebbles" to 2
        )
    }

    Column {
        simpsonsMap.value.forEach { (name, age) ->
            Row { Text("$name aged $age") }
        }
        Rule()

        flintstonesMap.forEach { (name, age) ->
            Row { Text("$name aged $age") }
        }
        Rule()

        Row {
            Button(onClick = {
                simpsonsMap.value = simpsonsMap.value
                    .minus("Homer")
                    .plus("Snowball" to 3)

                flintstonesMap.remove("Fred")
                flintstonesMap["Dino"] = 5
            }) {
                Text("Update Maps")
            }
        }
    }
}