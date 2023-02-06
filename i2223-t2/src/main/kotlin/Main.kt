import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

const val MAX_RATING = 3
fun main() {
    val movies: List<Score> =
        listOf(
            Score("Shining", 3),
            Score("Mass", 3),
            Score("Bambi", 3),
            Score("Avengers", 1)
        )
    application {
        Window(onCloseRequest = ::exitApplication, resizable = true, title = "Playlist") {
            ScoreView(movies, MAX_RATING)
        }
    }
}
