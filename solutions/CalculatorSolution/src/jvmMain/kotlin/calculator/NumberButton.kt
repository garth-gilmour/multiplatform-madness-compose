package calculator

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberButton(onClick: () -> Unit, number: Int) =
    Button(
        onClick = onClick,
        modifier = Modifier.padding(all = 5.dp)
    ) {
        Text(
            number.toString(),
            style = TextStyle(color = Color.Black, fontSize = 18.sp)
        )
    }
