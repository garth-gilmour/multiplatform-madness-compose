package components.demos.cinema

import androidx.compose.runtime.Composable
import model.cinema.MovieSummary
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun MovieRow(movie: MovieSummary, isEven: Boolean, callback: (MovieSummary) -> Unit) {
    Div(attrs = {
        onClick { callback(movie) }
        style {
            marginBottom(5.px)
            backgroundColor(if (isEven) Color.lightgray else Color.white)
            fontSize(12.pt)
        }
    } ) {
        Text(movie.title)
        Span(attrs = { style {
            paddingLeft(5.px)
            paddingRight(10.px)
        }}) { Text(":") }
        Text(movie.year.toString())
    }
}