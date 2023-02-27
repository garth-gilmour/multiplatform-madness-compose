package desktop.themes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Counter(label: String, value: Int) {
    Row {
        Text(label, modifier = Modifier.padding(end = 10.dp))
        Text(value.toString())
    }
}