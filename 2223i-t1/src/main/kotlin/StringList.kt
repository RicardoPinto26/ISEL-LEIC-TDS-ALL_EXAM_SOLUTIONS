import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StringList(lines: List<String>) =
    Column( modifier= Modifier.padding(horizontal= 5.dp)
        .background(Color.LightGray).fillMaxSize().padding(2.dp)
        .verticalScroll(rememberScrollState())
    ) {
        for(line in lines) Text(line)
    }
