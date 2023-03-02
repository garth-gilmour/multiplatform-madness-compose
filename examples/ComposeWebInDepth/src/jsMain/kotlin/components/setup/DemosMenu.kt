package components.setup

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Ol

@Composable
fun DemoMenu(callback: (String) -> Unit) {
    @Composable
    fun DemoLink(label: String, name: String) {
        Li {
            A(attrs = { onClick { callback(name) } }) {
                Text(label)
            }
        }
    }

    Ol {
        DemoLink("Hello Compose Web", "hello")
        DemoLink("Examples of inputs", "inputs")
    }
}