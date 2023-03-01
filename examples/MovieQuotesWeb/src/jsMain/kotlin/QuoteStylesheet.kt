package movie.quotes.web

import org.jetbrains.compose.web.css.*

object QuoteStylesheet : StyleSheet() {
    val topDivStyle by style {
        paddingTop(20.px)
        paddingLeft(10.px)
    }

    val hrStyle by style {
        color(Color.black)
        marginBottom(10.px)
        marginTop(10.px)
    }

    val quoteStyle by style {
        fontSize(18.pt)
    }

    val quoteSourceStyle by style {
        fontWeight("bold")
        paddingRight(5.px)
    }

    val quoteContentStyle by style {
        paddingLeft(10.px)
    }
}