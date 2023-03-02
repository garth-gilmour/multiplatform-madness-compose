package calculator.web

import androidx.compose.runtime.Composable
import calculator.web.CalculatorStylesheet.textDisplay
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun DisplayText(text: String) =
    Div({ classes(textDisplay) }) {
        Text(text)
    }