package desktop.layouts

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Buttons(numButtons: Int) {
    (1..numButtons).forEach {
        Button(onClick = {}) {
            Text("Button $it")
        }
    }
}