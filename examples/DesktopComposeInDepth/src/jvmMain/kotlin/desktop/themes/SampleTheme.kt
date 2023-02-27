package desktop.themes

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SampleTheme(content: @Composable () -> Unit) {
    val newTextStyle = TextStyle(
        color = Color.Red,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic
    )

    val colors = MaterialTheme.colors.copy(
        primary = Color.Green,
        background = Color.LightGray
    )
    val typography = MaterialTheme.typography.copy(
        body1 = newTextStyle
    )
    MaterialTheme(content = content, colors = colors, typography = typography)
}