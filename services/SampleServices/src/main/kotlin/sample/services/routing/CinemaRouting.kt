package sample.services.routing

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

import sample.services.db.readMoviesFile

val movies = readMoviesFile()

fun Application.configureCinema() {
    routing {
        route("/cinema") {
            get("/") {
                if(movies != null) {
                    call.respond(movies)
                }
                handleMissingMovies()
            }
            get("/{title}") {
                val title = call.parameters["title"]
                val movie = movies?.find { it.title == title }
                if (movie == null) {
                    call.respondText(
                        "No movie with title $title",
                        status = HttpStatusCode.NotFound
                    )
                } else {
                    call.respond(movie)
                }
            }
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.handleMissingMovies() {
    call.respondText(
        text = "Cannot find movies",
        status = HttpStatusCode.NotFound
    )
}

