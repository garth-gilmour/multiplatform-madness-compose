package desktop.themes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun ThemesApp() {
    val counter = remember { mutableStateOf(0) }
    SampleTheme {
        Column {
            Counter("Counter Value:", counter.value)

            Row {
                Button(onClick = { counter.value += 1 }) {
                    Text("Update UI")
                }
            }
        }
    }
}