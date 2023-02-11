import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

const val DEFAULT_CAPACITY = 20 // hard-coded

@Composable
fun MainContent() {
    var occupancy by remember { mutableStateOf(Occupancy(0, DEFAULT_CAPACITY)) }
    Row(
        Modifier.fillMaxWidth(),
        Arrangement.SpaceEvenly, Alignment.CenterVertically
    ) {
        OccupancyView(occupancy)
        Column {
            4 / 5
            Button(
                enabled = !occupancy.isFull,
                onClick = { occupancy = occupancy.increment() }
            ) { Text("+") }
            Button(
                enabled = !occupancy.isEmpty,
                onClick = { occupancy = occupancy.decrement() }
            ) { Text("-") }
        }
    }
}
