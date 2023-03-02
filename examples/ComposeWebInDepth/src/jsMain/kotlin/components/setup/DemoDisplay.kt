package components.setup

import androidx.compose.runtime.Composable
import components.demos.default.DefaultDemo
import components.demos.hello.HelloDemo
import components.demos.inputs.InputsDemo
import components.demos.movies.MoviesDemo

@Composable
fun DemoDisplay(name: String) = when(name) {
    "hello" -> HelloDemo()
    "inputs" -> InputsDemo()
    "movies" -> MoviesDemo()
    else -> DefaultDemo()
}