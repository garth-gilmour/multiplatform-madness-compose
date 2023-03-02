package components.setup

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun DemoMenu(callback: (String) -> Unit) {
    @Composable
    fun DemoLink(label: String, name: String) {
        Div {
            A(attrs = { onClick { callback(name) } }) {
                Text(label)
            }
        }
    }

    DemoLink("Hello Compose Web", "hello")
    DemoLink("Other Demo", "other")
}