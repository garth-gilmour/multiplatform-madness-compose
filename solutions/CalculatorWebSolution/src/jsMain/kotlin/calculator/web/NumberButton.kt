package calculator.web

import androidx.compose.runtime.Composable
import calculator.web.CalculatorStylesheet.boxed
import calculator.web.CalculatorStylesheet.numberButton
import org.jetbrains.compose.web.dom.*

@Composable
fun NumberButton(callback: () -> Unit, number: Int) =
    Span({ classes(boxed, numberButton) }) {
        Button(attrs = { onClick { callback() } }) {
            Text(number.toString())
        }
    }