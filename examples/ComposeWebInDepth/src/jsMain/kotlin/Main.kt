import AppStylesheet.boxed
import AppStylesheet.column
import AppStylesheet.contentColumn
import AppStylesheet.linksColumn

import components.setup.DemoMenu
import components.setup.DemoDisplay

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    var demoName by mutableStateOf("hello")

    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)

        Div({ classes (boxed) }) {
            Div({ classes (boxed, column, linksColumn) }) {
                DemoMenu { demoName = it }
            }
            Div({ classes (boxed, column, contentColumn) }) {
                DemoDisplay(demoName)
            }
        }
    }
}

