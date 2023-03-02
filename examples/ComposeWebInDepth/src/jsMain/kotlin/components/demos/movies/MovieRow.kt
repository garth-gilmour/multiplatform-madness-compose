package components.demos.movies

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun MovieRow(movie: MovieSummary, isEven: Boolean, callback: (MovieSummary) -> Unit) {
//    fun pickColor() = if (isEven) Color.LightGray else Color.White
//
//    val style = TextStyle(
//        color = Color.Black,
//        fontSize = 14.sp,
//    )
//    val textModifier = Modifier.padding(end = 10.dp)
//    val rowModifier = Modifier
//        .fillMaxWidth()
//        .background(color = pickColor())
//        .then(Modifier.onClick { callback(movie) })

    //Row(modifier = rowModifier) {
    Div(attrs = { onClick { callback(movie) } } ) {
        Text(
            movie.title)
//            style = style,
//            modifier = textModifier
//        )
        //Spacer(Modifier.weight(1f))
        Text(
            movie.year.toString())
//            style = style,
//            modifier = textModifier
//        )
    }
}