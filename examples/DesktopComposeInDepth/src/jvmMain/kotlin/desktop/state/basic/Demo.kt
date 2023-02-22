package desktop.state.basic

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun calculateCounter1(): Int {
    println("Calculating counter 1")
    return 101
}

fun calculateCounter2(): Int {
    println("Calculating counter 2")
    return 101
}

fun calculateCounter3(): Int {
    println("Calculating counter 3")
    return 101
}

@Composable
fun Counter(label: String, value: Int) {
    val counterStyle = TextStyle(color = Color.Black, fontSize = 18.sp)
    Row {
        Text(
            label,
            modifier = Modifier.padding(end = 10.dp),
            style = counterStyle.plus(TextStyle(fontWeight = FontWeight.Bold))
        )
        Text(value.toString(), style = counterStyle)
    }
}

@Composable
fun CountersDemo() {
    val counter1 = calculateCounter1()
    val counter2 = remember { calculateCounter2() }
    val counter3 = remember { mutableStateOf(calculateCounter3()) }

    Column {
        Counter("Counter 1:", counter1)
        Counter("Counter 2:", counter2)
        Counter("Counter 3:", counter3.value)

        Row {
            Button(onClick = { counter3.value += 1 }) {
                Text("Update UI")
            }
        }
    }
}