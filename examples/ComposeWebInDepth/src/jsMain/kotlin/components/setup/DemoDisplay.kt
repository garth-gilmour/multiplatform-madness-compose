package components.setup

import androidx.compose.runtime.Composable
import components.demos.DefaultDemo
import components.demos.HelloDemo
import components.demos.InputsDemo

@Composable
fun DemoDisplay(name: String) = when(name) {
    "hello" -> HelloDemo()
    "inputs" -> InputsDemo()
    else -> DefaultDemo()
}