package desktop.model.cinema

import kotlinx.serialization.Serializable

@Serializable
data class MovieSummary(
    var title: String,
    var year: Int
)