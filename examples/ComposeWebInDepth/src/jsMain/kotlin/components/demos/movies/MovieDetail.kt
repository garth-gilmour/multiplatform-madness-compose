package components.demos.movies

import androidx.compose.runtime.Composable
import components.util.Header
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun MovieDetail(movie: Movie) {
    Div {
        Div {
            Header("${movie.title}: ${movie.year}")
        }
        Div {
            Header("Cast:")
        }
        Div {
            movie.cast.forEach { name ->
                Div {
                    Text(name) //, modifier = Modifier.padding(start = 20.dp))
                }
            }
        }
    }
}