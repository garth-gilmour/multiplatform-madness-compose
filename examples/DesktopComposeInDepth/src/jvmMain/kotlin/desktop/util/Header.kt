package desktop.util

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Header(headerText: String) {
    Text(
        text = headerText,
        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
    )
}