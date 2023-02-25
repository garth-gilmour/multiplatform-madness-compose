package staff.search.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold

import staff.search.io.StaffSearchClient
import staff.search.model.Employee

@Composable
@Preview
fun StaffSearchApp(client: StaffSearchClient) {
    var staff by remember { mutableStateOf(emptyList<Employee>()) }

    LaunchedEffect(staff) {
        staff = client.fetchAllStaff()
    }

    Scaffold {
        Column {
            Row {
               StaffHeader()
            }
            Rule()
            Row {
                LazyColumn {
                    items(staff) {
                        StaffRow(it)
                    }
                }
            }
        }
    }
}