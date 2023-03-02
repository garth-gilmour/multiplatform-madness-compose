package calculator.web

import androidx.compose.runtime.Composable
import calculator.web.CalculatorStylesheet.boxed
import calculator.web.CalculatorStylesheet.operationButton
import org.jetbrains.compose.web.dom.*

@Composable
fun OperationButton(callback: () -> Unit, label: String) =
    Span({ classes(boxed, operationButton) }) {
        Button(attrs = { onClick { callback() } }) {
            Text(label)
        }
    }