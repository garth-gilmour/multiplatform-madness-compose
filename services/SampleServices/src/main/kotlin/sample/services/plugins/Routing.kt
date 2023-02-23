package sample.services.plugins

import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        // Static plugin. Try to access `/static/index.html`
        static("/info") {
            resources("static")
        }
    }
}
