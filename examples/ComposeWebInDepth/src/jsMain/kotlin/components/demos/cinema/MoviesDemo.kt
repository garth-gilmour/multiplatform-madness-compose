package components.demos.cinema

import AppStylesheet.scrollableDiv
import androidx.compose.runtime.*
import components.util.Divider
import components.util.SubHeader
import kotlinx.coroutines.launch
import model.cinema.Genre
import model.cinema.Movie
import model.cinema.MovieSummary
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

val client = MoviesClient("http://0.0.0.0:8080/cinema/")

@Composable
fun MoviesDemo() {
    val selectedGenre = remember { mutableStateOf(Genre.values()[0]) }
    val moviesInGenre = remember { mutableStateOf(emptyList<MovieSummary>()) }
    val selectedMovie = remember { mutableStateOf<Movie?>(null) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(selectedGenre.value) {
        println("Fetching movies by genre ${selectedGenre.value}")
        moviesInGenre.value = client.fetchMoviesByGenre(selectedGenre.value)
    }

    Div {
        Div {
            SubHeader("Genres")
        }
        Div({classes(scrollableDiv)}) {
            Genre.values().forEach { genre ->
                Div(attrs = {
                    onClick {
                        println("Changing genre to $genre")
                        selectedGenre.value = genre
                    }
                }) {
                    Text(genre.toString())
                }
            }
        }
        Divider()
        Div {
            SubHeader("Movies In The Genre ${selectedGenre.value}")
        }
        Div({classes(scrollableDiv)}) {
            moviesInGenre.value.forEachIndexed { index, movie ->
                MovieRow(movie, index % 2 == 0) {
                    scope.launch {
                        selectedMovie.value = client.fetchMovieByTitle(it.title)
                    }
                }
            }
        }
    }
    Divider()
    Div {
        val selected = selectedMovie.value
        if (selected != null) {
            MovieDetail(selected)
        }
    }
}