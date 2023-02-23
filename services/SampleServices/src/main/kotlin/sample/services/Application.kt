package sample.services

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import sample.services.routing.configureCinema
import sample.services.routing.configureStaff
import sample.services.plugins.configureHTTP
import sample.services.plugins.configureRouting
import sample.services.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureHTTP()
    configureRouting()
    configureCinema()
    configureStaff()
}
