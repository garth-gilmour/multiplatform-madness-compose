import org.jetbrains.compose.web.css.*

object AppStylesheet : StyleSheet() {
    val column by style {
        property("float", "left")
        padding(10.px)
    }

    val boxed by style {
        property("box-sizing", "border-box")
    }

    val linksColumn by style {
        property("width", "30%")
    }

    val contentColumn by style {
        property("width", "70%")
    }

    val verticallySpaced by style {
        paddingBottom(20.px)
    }
}