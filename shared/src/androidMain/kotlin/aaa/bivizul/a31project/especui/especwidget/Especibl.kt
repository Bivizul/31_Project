package aaa.bivizul.a31project.especui.especwidget

import aaa.bivizul.a31project.especdata.especutil.Especcon
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.fresco.FrescoImage

@Composable
actual fun Especibl() {

    val orientation = LocalConfiguration.current.orientation
    val imageUrl = when (orientation) {
        Configuration.ORIENTATION_PORTRAIT -> Especcon.ESPECBV
        else -> Especcon.ESPECBH
    }

    FrescoImage(
        imageUrl = imageUrl,
        imageOptions = ImageOptions(
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
    )

}