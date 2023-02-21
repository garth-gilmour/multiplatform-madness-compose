package calculator

import calculator.Operation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*

@Composable
fun Calculator() {
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

    CalculatorTheme {
        Column {
            Row {
                DisplayText(text = "${displayedTotal}")
            }
            Row {
                Column {
                    Row {
                        (1..3).forEach { num ->
                            NumberButton(onClick = { numberSelected(num) }, number = num)
                        }
                    }
                    Row {
                        (4..6).forEach { num ->
                            NumberButton(onClick = { numberSelected(num) }, number = num)
                        }
                    }
                    Row {
                        (7..9).forEach { num ->
                            NumberButton(onClick = { numberSelected(num) }, number = num)
                        }
                    }
                    Row {
                        NumberButton(onClick = { numberSelected(0) }, number = 0)
                    }
                }
                Column {
                    listOf(
                        { operationSelected(Add) } to "+",
                        { operationSelected(Subtract) } to "-",
                        { operationSelected(Multiply) } to "*",
                        { operationSelected(Divide) } to "/",
                        clearSelected to "Clear",
                        equalsSelected to "="
                    ).forEach {
                        OperationButton(onClick = it.first, label = it.second)
                    }
                }
            }
        }
    }
}

