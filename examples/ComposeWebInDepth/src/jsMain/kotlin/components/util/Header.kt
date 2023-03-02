package components.util

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text

@Composable
fun Header(text: String) {
    H2 {
        Text(text)
    }
}