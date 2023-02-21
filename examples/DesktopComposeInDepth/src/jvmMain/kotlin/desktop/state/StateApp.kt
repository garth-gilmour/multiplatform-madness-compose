package desktop.state

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import desktop.model.Person
import desktop.util.Rule

@Composable
@Preview
fun StateApp() {
    //Declare some state using the Delegated Property syntax (the 'by' keyword)
    var state1 by remember { mutableStateOf(123) }
    var state2 by remember { mutableStateOf("Sample Text") }
    var state3 by remember { mutableStateOf(Person("Dave", 27)) }

    //Declare some state using assignment syntax
    val state4 = remember { mutableStateOf(123) }
    val state5 = remember { mutableStateOf("Sample Text") }
    val state6 = remember { mutableStateOf(Person("Dave", 27)) }

    //Declare some state using destructuring
    val (state7Value, state7SetValue) = remember { mutableStateOf(123) }
    val (state8Value, state8SetValue) = remember { mutableStateOf("Sample Text") }
    val (state9Value, state9SetValue) = remember { mutableStateOf(Person("Dave", 27)) }

    MaterialTheme {
        Column {
            //Here we appear to access the state directly.
            //We are actually using the delegate object
            Row { Text(state1.toString())  }
            Row { Text(state2)  }
            Row { Text(state3.toString())  }
            Rule()

            //Here we must use the 'value' property of 'MutableState'
            Row { Text(state4.value.toString())  }
            Row { Text(state5.value)  }
            Row { Text(state6.value.toString())  }
            Rule()

            //Here we can access the state directly
            Row { Text(state7Value.toString())  }
            Row { Text(state8Value)  }
            Row { Text(state9Value.toString())  }
            Rule()
            Row {
                Button(onClick = {
                    //Here we appear to access the state
                    //But in reality are using the delegate
                    state1 = 456
                    state2 = "Different Text"
                    state3 = Person("Jane", 29)

                    //Here we must use the 'value' property of 'MutableState'
                    state4.value = 456
                    state5.value = "Different Text"
                    state6.value = Person("Jane", 29)

                    //Here we must use the modifier function
                    state7SetValue(546)
                    state8SetValue("Different Text")
                    state9SetValue(Person("Jane", 29))
                }) {
                    Text("Change State")
                }
            }
        }
    }
}