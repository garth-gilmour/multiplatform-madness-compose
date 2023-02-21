package movie.quotes

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row

@Composable
fun QuoteBox(quote: Quote) {
    val quoteStyle = TextStyle(color = Black, fontSize = 18.sp)
    Row(modifier = Modifier.padding(bottom = 10.dp)) {
        Text(
            text = quote.source,
            style = quoteStyle.plus(TextStyle(fontWeight = Bold)),
            modifier = Modifier.padding(end = 5.dp)
        )
        Text(":", style = quoteStyle)
        Text(
            text = quote.content,
            style = quoteStyle,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}
