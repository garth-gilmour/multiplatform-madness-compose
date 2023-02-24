package desktop.side.effects

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import desktop.model.cinema.Movie

@Composable
fun MovieDetail(movie: Movie) {
    Column {
        Row {
            Text(
                text = "${movie.title}: ${movie.year}",
                style = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
            )
        }
        Row {
            Text(
                text = "Cast:",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
            )
        }
        Row {
            Column {
                movie.cast.forEach { name ->
                    Row {
                        Text(name)
                    }
                }
            }
        }
    }
}