package components.util

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Text

@Composable
fun SubHeader(text: String) {
    H3 {
        Text(text)
    }
}