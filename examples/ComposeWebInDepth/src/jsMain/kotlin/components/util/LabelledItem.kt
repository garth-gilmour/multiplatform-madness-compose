package components.util

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text

@Composable
fun LabelledItem(label: String, value: String) {
    Li {
        Text(label)
        Text(":")
        Text(value)
    }
}