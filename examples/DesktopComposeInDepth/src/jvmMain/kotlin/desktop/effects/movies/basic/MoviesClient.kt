package desktop.effects.movies.basic

import desktop.model.cinema.Genre
import desktop.model.cinema.Movie
import desktop.model.cinema.MovieSummary
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

class MoviesClient(baseURL: String) {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            url(baseURL)
        }
    }

    suspend fun fetchMoviesByGenre(genre: Genre): List<MovieSummary> {
        val response = client.get("genre/${genre}")
        return response.body<List<MovieSummary>>()
    }

    suspend fun fetchMovieByTitle(title: String): Movie? {
        val encodedTitle = title.replace(" ", "%20")
        val url = "title/${encodedTitle}"
        return client.get(url).body<Movie>()
    }
}