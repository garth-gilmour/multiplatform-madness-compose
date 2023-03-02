package components.demos.movies

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

class MoviesClient(baseURL: String) {
    private val client = HttpClient(Js) {
        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            url(baseURL)
        }
    }

    suspend fun fetchMoviesByGenre(genre: Genre): List<MovieSummary> {
        val response = client.get("genre/${genre}")
        return response.body()
    }

    suspend fun fetchMovieByTitle(title: String): Movie? {
        val encodedTitle = title.replace(" ", "%20")
        val url = "title/${encodedTitle}"
        return client.get(url).body<Movie>()
    }
}