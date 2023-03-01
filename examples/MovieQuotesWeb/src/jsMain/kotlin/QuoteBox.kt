package movie.quotes.web

import androidx.compose.runtime.Composable

import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

import movie.quotes.web.QuoteStylesheet.quoteStyle
import movie.quotes.web.QuoteStylesheet.quoteSourceStyle
import movie.quotes.web.QuoteStylesheet.quoteContentStyle


@Composable
fun QuoteBox(quote: Quote) {
    Div {
        Span({ classes(quoteStyle, quoteSourceStyle) }) {
            Text(quote.source)
        }
        Span({ classes(quoteStyle) }) {
            Text(":")
        }
        Span({ classes(quoteStyle, quoteContentStyle) }
        ) {
            Text(quote.content)
        }
    }
}