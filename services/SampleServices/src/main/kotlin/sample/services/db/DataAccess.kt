package sample.services.db

import sample.services.model.cinema.Movie
import sample.services.model.staff.Employee
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

@OptIn(ExperimentalSerializationApi::class)
fun readMoviesFile(): List<Movie>? {
    val fileStream = object {}.javaClass.getResourceAsStream("/data/moviesData.json")
    return fileStream?.let { Json.decodeFromStream(it) }
}

@OptIn(ExperimentalSerializationApi::class)
fun readStaffFile(): List<Employee>? {
    val fileStream = object {}.javaClass.getResourceAsStream("/data/staffData.json")
    return fileStream?.let { Json.decodeFromStream(it) }
}