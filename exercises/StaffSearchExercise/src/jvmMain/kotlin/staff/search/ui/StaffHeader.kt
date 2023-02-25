package staff.search.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun StaffHeader() {
    Text(
        "Names Of The Employees",
        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
    )
}