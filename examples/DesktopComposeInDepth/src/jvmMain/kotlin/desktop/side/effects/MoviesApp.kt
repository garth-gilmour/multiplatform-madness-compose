package desktop.side.effects

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.onClick
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import desktop.model.cinema.Genre
import desktop.model.cinema.Movie
import desktop.model.cinema.MovieSummary
import desktop.util.Header
import desktop.util.Rule
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesApp(client: MoviesClient) {
    val selectedGenre = remember { mutableStateOf(Genre.values()[0]) }
    val moviesInGenre = remember { mutableStateOf(emptyList<MovieSummary>()) }
    val selectedMovie = remember { mutableStateOf<Movie?>(null) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(selectedGenre.value) {
        moviesInGenre.value = client.fetchMoviesByGenre(selectedGenre.value)
    }

    Scaffold(modifier = Modifier.padding(10.dp)) {
        Column {
            Row {
                Header("Genres")
            }
            Row {
                LazyColumn(modifier = Modifier.height(100.dp)) {
                    items(Genre.values()) { genre ->
                        Row(modifier = Modifier.onClick {
                            selectedGenre.value = genre
                        }) {
                            Text(genre.toString())
                        }
                    }
                }
            }
            Rule()
            Row {
                Header("Movies In The Genre ${selectedGenre.value}")
            }
            Row {
                LazyColumn(modifier = Modifier.height(400.dp)) {
                    itemsIndexed(moviesInGenre.value) { index, movie ->
                        MovieRow(movie, index % 2 == 0) {
                            scope.launch {
                                selectedMovie.value = client.fetchMovieByTitle(it.title)
                            }
                        }
                    }
                }
            }
            Rule()
            Row {
                val selected = selectedMovie.value
                if(selected != null) {
                    MovieDetail(selected)
                }
            }
        }
    }
}