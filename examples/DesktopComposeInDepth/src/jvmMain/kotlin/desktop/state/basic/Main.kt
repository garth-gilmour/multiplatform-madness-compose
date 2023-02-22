package desktop.state.basic

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
fun buildWindowState() = rememberWindowState().apply {
    size = DpSize(Dp(200f), Dp(150f))
    position = WindowPosition(100.dp, 100.dp)
}

fun main() = application {
    Window(
        title = "Demo Of Managing State",
        onCloseRequest = ::exitApplication,
        state = buildWindowState()
    ) {
        CountersDemo()
    }
}