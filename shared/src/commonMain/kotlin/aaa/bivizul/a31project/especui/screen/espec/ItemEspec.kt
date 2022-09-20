package aaa.bivizul.a31project.especui.screen.espec

import aaa.bivizul.a31project.especdata.especmodel.Getespec
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface ItemEspec {

    val models: Value<Model>
    val state: StateFlow<Getespec?>

    fun onReplace()

    data class Model(
        val activity: Any
    )

}