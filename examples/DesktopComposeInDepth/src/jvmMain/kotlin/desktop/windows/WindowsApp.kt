package desktop.windows

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun WindowsApp() {
    MaterialTheme {
        Row(modifier = Modifier.padding(all = 20.dp)) {
            Text("Sample Text")
        }
    }
}