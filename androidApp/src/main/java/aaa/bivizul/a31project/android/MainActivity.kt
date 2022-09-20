package aaa.bivizul.a31project.android

import aaa.bivizul.a31project.especdata.especutil.checkEspecnet
import aaa.bivizul.a31project.especdata.especutil.getEspecdlg
import aaa.bivizul.a31project.especui.root.ItemRootComponent
import aaa.bivizul.a31project.especui.root.RootSetContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (checkEspecnet(this)) {
            val root = ItemRootComponent(
                componentContext = defaultComponentContext(),
                context = this@MainActivity
            )
            setContent {
                RootSetContent(root = root)
            }
        } else {
            getEspecdlg(this)
        }
    }
}

