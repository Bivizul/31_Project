package aaa.bivizul.a31project.especui.screen.intro

import aaa.bivizul.a31project.especdata.especmodel.EspecItem
import aaa.bivizul.a31project.especdata.especstore.EspecItemStore
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class ItemIntroComponent(
    componentContext: ComponentContext,
    val especItemStore: EspecItemStore,
    itemId: Int,
) : ItemIntro, ComponentContext by componentContext {

    private val _models = MutableValue(ItemIntro.Model(itemId))
    override val models: Value<ItemIntro.Model> = _models

    override val state: StateFlow<List<EspecItem>?> = especItemStore.especItem

}