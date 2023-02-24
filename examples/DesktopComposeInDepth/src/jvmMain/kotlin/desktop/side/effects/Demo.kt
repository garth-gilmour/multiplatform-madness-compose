package desktop.side.effects

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.onClick
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import desktop.model.cinema.Genre
import desktop.model.cinema.Movie
import desktop.util.Rule
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesDemo(client: HttpClient) {
    val selectedGenre = remember { mutableStateOf(Genre.values()[0]) }
    val selectedMovies = remember { mutableStateOf(emptyList<Movie>()) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(selectedGenre.value) {
        val response = client.get("http://0.0.0.0:8080/cinema/genre/${selectedGenre.value}")
        val movies = response.body<List<Movie>>()
        selectedMovies.value = movies
    }

    Scaffold {
        Column {
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
                LazyColumn(modifier = Modifier.height(100.dp)) {
                    items(selectedMovies.value) { movie ->
                        Row {
                            Text(movie.title)
                            Text(movie.year.toString())
                            Text(movie.cast.toString())
                        }
                    }
                }
            }
            /*
            Row {
                Button(onClick = {
                    scope.launch {
                        val response = client.get("http://0.0.0.0:8080/cinema/")
                        val movies = response.body<List<Movie>>()
                        movies.forEach {
                            println(it.year)
                        }
                    }
                }) {
                    Text("Fetch Movies")
                }
            }*/
        }
    }
}