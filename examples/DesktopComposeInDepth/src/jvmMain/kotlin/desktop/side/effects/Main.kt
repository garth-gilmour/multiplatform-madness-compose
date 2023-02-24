package desktop.side.effects

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

@Composable
fun buildWindowState() = rememberWindowState().apply {
    size = DpSize(Dp(500f), Dp(800f))
    position = WindowPosition(100.dp, 100.dp)
}

val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json()
    }
}

fun main() = application {
    Window(
        title = "Demo Of Managing State",
        onCloseRequest = ::exitApplication,
        state = buildWindowState()
    ) {
        MoviesApp(client)
    }
}