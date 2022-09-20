package aaa.bivizul.a31project.especui.root

import aaa.bivizul.a31project.especui.especwidget.Especibl
import aaa.bivizul.a31project.especui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RootSetContent(
    root: ItemRootComponent
) {
    MyApplicationTheme {
        Especibl()
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            RootContent(root)
        }
    }
}
