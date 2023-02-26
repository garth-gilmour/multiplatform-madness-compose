package desktop.effects.movies.basic

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.onClick
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import desktop.model.cinema.MovieSummary

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieRow(movie: MovieSummary, isEven: Boolean, callback: (MovieSummary) -> Unit) {
    fun pickColor() = if (isEven) Color.LightGray else Color.White

    val style = TextStyle(
        color = Color.Black,
        fontSize = 14.sp,
    )
    val textModifier = Modifier.padding(end = 10.dp)
    val rowModifier = Modifier
        .fillMaxWidth()
        .background(color = pickColor())
        .then(Modifier.onClick { callback(movie) })

    Row(modifier = rowModifier) {
        Text(
            movie.title,
            style = style,
            modifier = textModifier
        )
        Spacer(Modifier.weight(1f))
        Text(
            movie.year.toString(),
            style = style,
            modifier = textModifier
        )
    }
}