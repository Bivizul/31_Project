package aaa.bivizul.a31project.especui.screen.espec

import aaa.bivizul.a31project.especdata.especmodel.Espec
import aaa.bivizul.a31project.especdata.especmodel.Getespec
import aaa.bivizul.a31project.especdata.especstore.EspecStore
import aaa.bivizul.a31project.especdata.especutil.*
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class ItemEspecComponent(
    componentContext: ComponentContext,
    context: Any,
    apostStore: EspecStore,
    private val onReplaceCur: () -> Unit
) : ItemEspec, ComponentContext by componentContext {

    private val _models = MutableValue(ItemEspec.Model(activity = context))
    override val models: Value<ItemEspec.Model> = _models

    override val state: StateFlow<Getespec?> = apostStore.getespec

    init {
        try {
            apostStore.getGetapost(
                Espec(
                    getEspecmm(),
                    getEspecsim(context),
                    getEspecid(context),
                    getEspecl(),
                    getEspect()
                )
            )
        } catch (e: Exception) {
            getEspecdlg(context)
        }
    }

    override fun onReplace() {
        onReplaceCur()
    }
}