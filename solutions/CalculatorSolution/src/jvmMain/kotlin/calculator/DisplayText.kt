package calculator

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayText(text: String) =
    Text(
        text = text,
        style = TextStyle(color = Color.Black, fontSize = 28.sp),
        modifier = Modifier.padding(all = 10.dp)
    )
