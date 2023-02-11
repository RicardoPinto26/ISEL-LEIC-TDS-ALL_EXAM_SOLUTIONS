import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun OccupancyView(occupancy: Occupancy) = Column(
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text("${occupancy.current}", style = MaterialTheme.typography.h4)
    Text("of")
    Text("${occupancy.capacity}", style = MaterialTheme.typography.h6)
}