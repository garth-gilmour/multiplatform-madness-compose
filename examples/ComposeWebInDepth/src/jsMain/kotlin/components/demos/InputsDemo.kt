package components.demos

import AppStylesheet.verticallySpaced
import androidx.compose.runtime.*
import components.util.Divider
import components.util.Header
import components.util.LabelledItem
import org.jetbrains.compose.web.dom.*

@Composable
fun InputsDemo() {
    var sampleDate by remember { mutableStateOf("2023-01-02") }
    var samplePassword by remember { mutableStateOf("wn1hgb") }
    var sampleRangeValue by remember { mutableStateOf(50) }

    Header("Examples of Inputs")
    Div({ classes(verticallySpaced) }) {
        DateInput(value = sampleDate) {
            onInput { event ->
                println("Selected ${event.value}")
                sampleDate = event.value
            }
        }
    }

    Div({ classes(verticallySpaced) }) {
        PasswordInput(value = samplePassword) {
            onInput { event ->
                println("Selected ${event.value}")
                samplePassword = event.value
            }
        }
    }

    Div {
        RangeInput(
            value = sampleRangeValue,
            min = 10,
            max = 100,
            step = 5
        ) {
            onInput { event ->
                println("Selected ${event.value}")
                sampleRangeValue = event.value?.toInt() ?: 0
            }
        }
    }

    Divider()

    Ul {
        LabelledItem("Selected Date", sampleDate)
        LabelledItem("Selected Password", samplePassword)
        LabelledItem("Selected Range", sampleRangeValue.toString())
    }

}