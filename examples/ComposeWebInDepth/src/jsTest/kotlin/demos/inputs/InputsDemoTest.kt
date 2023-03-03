package demos.inputs

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import components.demos.cinema.MovieRow
import components.demos.inputs.InputsDemo
import model.cinema.MovieSummary
import org.jetbrains.compose.web.testutils.ComposeWebExperimentalTestsApi
import org.jetbrains.compose.web.testutils.runTest
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.asList
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ComposeWebExperimentalTestsApi::class)
class InputsDemoTest {
    @Test
    fun testButton() = runTest {
        composition {
            InputsDemo()
        }

        val inputs = root
            .getElementsByTagName("INPUT")
            .asList()

        val rangeInput = inputs.first { element ->
            element.getAttribute("type") == "range"
        } as HTMLInputElement

        assertEquals("50", rangeInput.value)

        rangeInput.stepUp()
        assertEquals("55", rangeInput.value)

        rangeInput.stepDown(2)
        assertEquals("45", rangeInput.value)
    }
}