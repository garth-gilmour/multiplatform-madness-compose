package sample.services.model.cinema

import kotlinx.serialization.Serializable
import sample.services.model.cinema.Genre

@Serializable
data class Movie(
    var title: String,
    var year: Int,
    var genres: List<Genre>,
    var cast: List<String>
) {
}