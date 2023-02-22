package desktop.hof

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
fun buildWindowState() = rememberWindowState().apply {
    size = DpSize(Dp(300f), Dp(150f))
    position = WindowPosition(100.dp, 100.dp)
}

fun buildLabeledValueWidget(label: String, size: TextUnit): @Composable (String) -> Unit {
    return { value: String ->
        val counterStyle = TextStyle(color = Color.Black, fontSize = size)
        Row {
            Text(
                label,
                modifier = Modifier.padding(end = 10.dp),
                style = counterStyle.plus(TextStyle(fontWeight = FontWeight.Bold))
            )
            Text(value, style = counterStyle)
        }
    }
}

fun main() = application {
    Window(
        title = "Demo Of Higher Order Functions",
        onCloseRequest = ::exitApplication,
        state = buildWindowState()
    ) {
        val widget1 = remember { buildLabeledValueWidget("Title 1", 16.sp) }
        val widget2 = remember { buildLabeledValueWidget("Title 2", 20.sp) }

        Column {
            widget1("Value A")
            widget1("Value B")
            widget2("Value C")
            widget2("Value D")
        }
    }
}
