package components.demos.movies

import kotlinx.serialization.Serializable

@Serializable
data class MovieSummary(
    var title: String,
    var year: Int
)