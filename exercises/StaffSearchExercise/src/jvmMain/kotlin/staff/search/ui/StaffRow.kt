package staff.search.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import staff.search.model.Employee

@Composable
fun StaffRow(it: Employee) {
    Row {
        Text(
            "${it.name.first} ${it.name.last}",
            modifier = Modifier.padding(start = 10.dp),
            style = TextStyle(fontSize = 12.sp)
        )
    }
}