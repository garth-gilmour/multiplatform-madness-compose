package desktop.layouts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LayoutsApp() {
    val modifier = Modifier
        .border(BorderStroke(2.dp, Color.Black))
        .then(Modifier.padding(all = 5.dp))

    Column {
        Row(modifier = modifier) {
            Buttons(5)
        }
        Row {
            Column(modifier = modifier) {
                Buttons(5)
            }
        }
        Row(modifier = modifier.then(Modifier.align(Alignment.End))) {
            Buttons(3)
        }
    }
}