package desktop.effects.disposing

import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
fun buildWindowState() = rememberWindowState().apply {
    size = DpSize(Dp(400f), Dp(500f))
    position = WindowPosition(100.dp, 100.dp)
}

fun main() = application {
    Window(
        title = "Disposing Of Side Effects",
        onCloseRequest = ::exitApplication,
        state = buildWindowState()
    ) {
        DisposingStateApp()
    }
}
