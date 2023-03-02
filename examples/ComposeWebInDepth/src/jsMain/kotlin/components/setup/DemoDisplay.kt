package components.setup

import androidx.compose.runtime.Composable
import components.demos.DefaultDemo
import components.demos.HelloDemo
import components.demos.OtherDemo

@Composable
fun DemoDisplay(name: String) = when(name) {
    "hello" -> HelloDemo()
    "other" -> OtherDemo()
    else -> DefaultDemo()
}