package desktop.side.effects

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.onClick
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import desktop.model.cinema.Genre
import desktop.model.cinema.Movie
import desktop.model.cinema.MovieSummary
import desktop.util.Rule
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.launch
import java.net.URLEncoder


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesApp(client: HttpClient) {
    val selectedGenre = remember { mutableStateOf(Genre.values()[0]) }
    val moviesInGenre = remember { mutableStateOf(emptyList<MovieSummary>()) }
    val selectedMovie = remember { mutableStateOf<Movie?>(null) }

    val scope = rememberCoroutineScope()

    LaunchedEffect(selectedGenre.value) {
        val response = client.get("http://0.0.0.0:8080/cinema/genre/${selectedGenre.value}")
        val movies = response.body<List<MovieSummary>>()
        moviesInGenre.value = movies
    }

    Scaffold {
        Column {
            Row {
                Text(
                    text = "Genres:",
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                )
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
                LazyColumn(modifier = Modifier.height(500.dp)) {
                    itemsIndexed(moviesInGenre.value) { index, movie ->
                        MovieRow(movie, index % 2 == 0) {
                            val encodedTitle = it.title.replace(" ", "%20")
                            scope.launch {
                                val url = "http://0.0.0.0:8080/cinema/title/${encodedTitle}"
                                val response = client.get(url)
                                val movie = response.body<Movie>()
                                selectedMovie.value = movie
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