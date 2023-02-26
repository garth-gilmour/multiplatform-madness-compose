package movie.quotes

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.TextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun DerivedStateApp() {
    @Composable
    fun TextWithPadding(value: String) {
        Text(value, modifier = Modifier.padding(end = 20.dp))
    }

    @Composable
    fun EmailDisplay(value: String) {
        Text(value, style = TextStyle(fontSize = 18.sp))
    }



    var forename by remember { mutableStateOf("Jane") }
    var surname by remember { mutableStateOf("Smith") }
    val email by remember {
        derivedStateOf {
            "${forename}.${surname}@megacorp.com"
        }
    }

    MaterialTheme {
        Column(modifier = Modifier.padding(start = 10.dp, top = 20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                TextWithPadding("Forename:")
                TextField(value = forename, onValueChange = {
                    forename = it
                })
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                TextWithPadding("Surname:")
                TextField(value = surname, onValueChange = {
                    surname = it
                })
            }

            Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
            )

            Row {
                EmailDisplay("Email is $email")
            }
        }
    }
}

