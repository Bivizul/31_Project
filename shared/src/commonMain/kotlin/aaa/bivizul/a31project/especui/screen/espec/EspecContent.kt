package aaa.bivizul.a31project.especui.screen.espec

import aaa.bivizul.a31project.especdata.especmodel.Especvar
import aaa.bivizul.a31project.especdata.especutil.getEspectactoff
import aaa.bivizul.a31project.especdata.especutil.sigEspecoff
import aaa.bivizul.a31project.especui.especwidget.Especcp
import aaa.bivizul.a31project.especui.especwidget.especct
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kotlinx.coroutines.delay

@Composable
fun EspecContent(
    component: ItemEspec,
) {

    val getespec by component.state.collectAsState()
    val model by component.models.subscribeAsState()

    Especcp()

    LaunchedEffect(Unit) {
        delay(1000)
        getespec?.getespec?.let {
            if (it == Especvar.EVNO.ev) {
                component.onReplace()
            } else if (it == Especvar.EVNP.ev) {
                sigEspecoff()
                component.onReplace()
            } else {
                especct(model.activity, it)
                getEspectactoff(model.activity)
            }
        }
    }

}