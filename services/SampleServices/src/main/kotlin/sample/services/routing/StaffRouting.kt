package sample.services.routing

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

import sample.services.db.readStaffFile

val staff = readStaffFile()

fun Application.configureStaff() {
    routing {
        route("/staff") {
            get("/") {
                if(staff != null) {
                    call.respond(staff)
                }
                handleMissingStaff()
            }
            get("/{id}") {
                val id = call.parameters["id"]
                val employee = staff?.find { it.id == id }
                if (employee == null) {
                    call.respondText(
                        "No employee with id $id",
                        status = HttpStatusCode.NotFound
                    )
                } else {
                    call.respond(employee)
                }
            }
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.handleMissingStaff() {
    call.respondText(
        text = "Cannot find staff",
        status = HttpStatusCode.NotFound
    )
}

