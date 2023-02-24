package desktop.model.cinema

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    var title: String,
    var year: Int,
    var genres: List<Genre>,
    var cast: List<String>
) {
}