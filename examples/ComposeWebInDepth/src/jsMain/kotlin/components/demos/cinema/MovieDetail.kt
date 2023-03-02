package components.demos.cinema

import androidx.compose.runtime.Composable
import components.util.Header
import components.util.SubHeader
import model.cinema.Movie
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun MovieDetail(movie: Movie) {
    Div {
        Div {
            SubHeader("${movie.title}: ${movie.year}")
        }
        Div {
            SubHeader("Cast:")
        }
        Div {
            movie.cast.forEach { name ->
                Div(attrs = { style { paddingLeft(20.px) }}) {
                    Text(name)
                }
            }
        }
    }
}