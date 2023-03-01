package movie.quotes.web

import movie.quotes.web.components.MovieQuotesApp
import movie.quotes.web.components.QuoteStylesheet
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        Style(QuoteStylesheet)

        MovieQuotesApp()
    }
}

