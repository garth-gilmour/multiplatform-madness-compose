package components.demos.movies

import AppStylesheet.scrollableDiv
import androidx.compose.runtime.*
import components.util.Divider
import components.util.Header
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

//val client = HttpClient(Js) {
//    defaultRequest {
//        url("http://0.0.0.0:8080/")
//    }
//}

//@Composable
//fun MoviesDemo() {
//    val moviesText = remember { mutableStateOf("") }
//
//    Text("The Movies Demo")
//
//    LaunchedEffect(moviesText.value) {
//        moviesText.value = client.get("cinema/").bodyAsText()
//    }
//
//    Text(moviesText.value)
//}

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
            Header("Genres")
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
            Header("Movies In The Genre ${selectedGenre.value}")
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