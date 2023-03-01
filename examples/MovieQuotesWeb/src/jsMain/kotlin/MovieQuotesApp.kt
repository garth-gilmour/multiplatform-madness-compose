package movie.quotes.web

import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun MovieQuotesApp() {
    @Composable
    fun TextWithPadding(value: String) {
        Span({ style { paddingRight(20.px) } }) {
            Text(value)
        }
    }

    var quotes by remember {
        mutableStateOf(buildInitialQuotes())
    }

    var newQuote by remember {
        mutableStateOf(Quote("default source", "default text"))
    }

    Div(attrs = { classes(QuoteStylesheet.topDivStyle) }) {
        quotes.forEach { QuoteBox(it) }

        Hr(attrs = { classes(QuoteStylesheet.hrStyle) })

        Div {
            TextWithPadding("New Source:")
            Input(type = InputType.Text) {
                value(newQuote.source)
                onInput { event ->
                    newQuote = newQuote.copy(source = event.value)
                }
            }
        }

        Div {
            TextWithPadding("New Text:")
            Input(type = InputType.Text) {
                value(newQuote.content)
                onInput { event ->
                    newQuote = newQuote.copy(content = event.value)
                }
            }
        }

        Div {
            Button(attrs = {
                onClick {
                    quotes = quotes.plus(newQuote)
                }
            }) {
                Text("Add New Quote")
            }
        }
    }
}