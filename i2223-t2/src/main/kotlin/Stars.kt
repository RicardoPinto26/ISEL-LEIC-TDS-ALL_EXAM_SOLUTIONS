import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.onClick
import androidx.compose.material.contentColorFor
import androidx.compose.ui.Modifier

@Composable
fun ImageResource(resource: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier.clickable { onClick() }) {
        Image(painterResource(resource), resource)
    }
}

@Composable
fun Stars(rating:Int, max:Int, onChange:(Int)->Unit) {
    Row(){
        for (i in 1 .. rating)
            ImageResource(
                resource = "black_pawn.png",
                onClick = {onChange(i)}
            )

        for (i in rating+1 .. max)
            ImageResource(
                resource = "white_pawn.png",
                onClick = {onChange(i)}
            )
    }
}