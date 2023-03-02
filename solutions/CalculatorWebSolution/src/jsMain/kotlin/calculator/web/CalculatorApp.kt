package calculator.web

import androidx.compose.runtime.*
import calculator.web.CalculatorStylesheet.column
import calculator.web.CalculatorStylesheet.buttonsColumn
import calculator.web.CalculatorStylesheet.boxed
import calculator.web.CalculatorStylesheet.operationsColumn
import org.jetbrains.compose.web.dom.Div

import calculator.web.Operation.*

@Composable
fun CalculatorApp() {
    var savedTotal by remember { mutableStateOf(0) }
    var displayedTotal by remember { mutableStateOf(0) }
    var operationOngoing by remember { mutableStateOf(Operation.None) }
    var operationJustChanged by remember { mutableStateOf(false) }

    val numberSelected = { num: Int ->
        when {
            operationJustChanged -> {
                operationJustChanged = false
                savedTotal = displayedTotal
                displayedTotal = num
            }

            displayedTotal == 0 -> {
                displayedTotal = num
            }

            else -> {
                displayedTotal = (displayedTotal * 10) + num
            }
        }
    }

    val clearSelected = {
        displayedTotal = 0
        savedTotal = 0
        operationOngoing = Operation.None
        operationJustChanged = false
    }

    val doOperation = {
        val saved = savedTotal
        val displayed = displayedTotal

        when (operationOngoing) {
            Add -> displayedTotal = saved + displayed
            Subtract -> displayedTotal = saved - displayed
            Multiply -> displayedTotal = saved * displayed
            Divide -> displayedTotal = saved / displayed
            else -> throw IllegalStateException("No operation to execute!")
        }
    }

    val operationSelected = { op: Operation ->
        operationJustChanged = true
        if (operationOngoing != None) {
            doOperation()
            savedTotal = displayedTotal
        }
        operationOngoing = op
    }

    val equalsSelected = {
        doOperation()
        operationOngoing = Operation.None
    }

    Div({ classes(boxed) }) {
        Div {
            DisplayText(text = "${displayedTotal}")
        }
        Div({ classes(boxed, column, buttonsColumn) }) {
            Div {
                (1..3).forEach { num ->
                    NumberButton(callback = { numberSelected(num) }, number = num)
                }
            }
            Div {
                (4..6).forEach { num ->
                    NumberButton(callback = { numberSelected(num) }, number = num)
                }
            }
            Div {
                (7..9).forEach { num ->
                    NumberButton(callback = { numberSelected(num) }, number = num)
                }
            }
            Div {
                NumberButton(callback = { numberSelected(0) }, number = 0)
            }
        }
        Div({ classes(boxed, column, operationsColumn) }) {
            listOf(
                { operationSelected(Add) } to "+",
                { operationSelected(Subtract) } to "-",
                { operationSelected(Multiply) } to "*",
                { operationSelected(Divide) } to "/",
                clearSelected to "Clear",
                equalsSelected to "="
            ).forEach {
                Div {
                    OperationButton(callback = it.first, label = it.second)
                }
            }
        }
    }
}