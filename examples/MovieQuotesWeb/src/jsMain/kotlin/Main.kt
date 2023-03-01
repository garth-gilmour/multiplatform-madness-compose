package movie.quotes.web

import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        Style(QuoteStylesheet)

        MovieQuotesApp()
    }
}

