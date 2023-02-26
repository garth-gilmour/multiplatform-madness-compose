package desktop.effects.disposing

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.time.LocalTime

@Composable
@Preview
fun DisposingStateApp() {
    val timeCheck = remember { mutableStateOf(LocalTime.now()) }
    val messages = remember { mutableStateListOf("Initial Item") }

    DisposableEffect(timeCheck.value) {
        println("Creating the effect")

        onDispose {
            println("Disposing of the effect")
        }
    }

    MaterialTheme {
        Column(modifier = Modifier.padding(start = 10.dp, top = 20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                LazyColumn {
                    items(messages) {
                        Text(it)
                    }
                }
            }

            TabRowDefaults.Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
            )

            Row {
                Button(onClick = {
                    with(timeCheck.value) {
                        messages.add("Item with timestamp ${hour}:${minute}:${second}")
                    }
                }) {
                    Text("Add Item")
                }
                Button(onClick = { timeCheck.value = LocalTime.now() }) {
                    Text("Reset Time")
                }
            }
        }
    }
}

