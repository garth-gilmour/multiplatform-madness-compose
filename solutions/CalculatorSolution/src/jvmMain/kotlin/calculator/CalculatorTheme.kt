package calculator

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CalculatorTheme(content: @Composable () -> Unit) {
    val colors = MaterialTheme.colors.copy(primary = Color.LightGray)
    MaterialTheme(content = content, colors = colors)
}
