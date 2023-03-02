package calculator.web

import org.jetbrains.compose.web.css.*

object CalculatorStylesheet : StyleSheet() {
    val column by style {
        property("float", "left")
        padding(10.px)
    }

    val boxed by style {
        property("box-sizing", "border-box")
    }

    val buttonsColumn by style {
        property("width", "30%")
    }

    val operationsColumn by style {
        property("width", "70%")
    }

    val textDisplay by style {
        padding(10.px)
        fontSize(28.pt)
    }

    val numberButton by style {
        padding(10.px)
        fontSize(20.pt)
    }

    val operationButton by style {
        padding(5.px)
        fontSize(16.pt)
    }
}