package desktop.side.effects

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.onClick
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import desktop.model.cinema.Movie

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieRow(movie: Movie, isEven: Boolean, callback: (Movie) -> Unit) {
    fun pickColor() = if (isEven) Color.LightGray else Color.White

    val style = TextStyle(
        color = Color.Black,
        fontSize = 12.sp,
    )
    val textModifier = Modifier.padding(end = 10.dp)
    val rowModifier = Modifier
        .fillMaxWidth()
        .background(color = pickColor())
        .then(Modifier.onClick { callback(movie) })

    Row(modifier = rowModifier) {
        Text(movie.title, style = style, modifier = textModifier)
        Text(movie.year.toString(), style = style, modifier = textModifier)
        Text(movie.cast.toString(), style = style, modifier = textModifier)
    }
}