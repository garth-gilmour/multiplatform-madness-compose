package desktop.side.effects

import desktop.model.cinema.Genre
import desktop.model.cinema.Movie
import desktop.model.cinema.MovieSummary
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

class MoviesClient {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun fetchMoviesByGenre(genre: Genre): List<MovieSummary> {
        val response = client.get("http://0.0.0.0:8080/cinema/genre/${genre}")
        return response.body<List<MovieSummary>>()
    }

    suspend fun fetchMovieByTitle(title: String): Movie? {
        val encodedTitle = title.replace(" ", "%20")
        val url = "http://0.0.0.0:8080/cinema/title/${encodedTitle}"
        return client.get(url).body<Movie>()
    }
}