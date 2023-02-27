package desktop.windows

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*

@Composable
fun buildWindowState() = rememberWindowState().apply {
    size = DpSize(Dp(400f), Dp(150f))
    position = WindowPosition(100.dp, 100.dp)
}

fun main() = application {
    fun exitApp() {
        println("Bye for now")
        exitApplication()
    }

    Window(
        title = "Using Windows",
        onCloseRequest = ::exitApplication,
        state = buildWindowState()
    ) {
        MenuBar {
            Menu("File") {
                Item("Option 1", onClick = { println("File -> Option 1 invoked") })
                Item("Option 2", onClick = { println("File -> Option 2 invoked") })
                Item("Exit", onClick = ::exitApp)
            }
            Menu("Edit") {
                Item("Option 1", onClick = { println("Edit -> Option 1 invoked") })
                Item("Option 2", onClick = { println("Edit -> Option 2 invoked") })
            }
        }
        WindowsApp()
    }
}