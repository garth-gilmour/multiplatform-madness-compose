package demos.cinema

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import components.demos.cinema.MovieRow
import model.cinema.MovieSummary
import org.jetbrains.compose.web.testutils.ComposeWebExperimentalTestsApi
import org.jetbrains.compose.web.testutils.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ComposeWebExperimentalTestsApi::class)
class MovieRowTest {
    @Test
    fun testMovieRow() = runTest {
        var summary by mutableStateOf(MovieSummary("Jaws", 1975))

        composition {
            MovieRow(summary, true) {}
        }

        val rootElement = root.firstElementChild

        //We expect <div>Jaws<span>:</span>1975</div>
        assertEquals("DIV", rootElement?.tagName)
        assertEquals("Jaws", rootElement?.firstChild?.nodeValue)
        assertEquals("SPAN", rootElement?.firstElementChild?.tagName)
        assertEquals(":", rootElement?.firstElementChild?.textContent)
        assertEquals("1975", rootElement?.lastChild?.nodeValue)

        summary = MovieSummary("Highlander",1986)
        waitForRecompositionComplete()

        //We expect <div>Highlander<span>:</span>1986</div>
        assertEquals("Highlander", rootElement?.firstChild?.nodeValue)
        assertEquals("1986", rootElement?.lastChild?.nodeValue)
    }
}