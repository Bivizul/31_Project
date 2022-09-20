package aaa.bivizul.a31project.especui.screen.market

import aaa.bivizul.a31project.especdata.especmodel.EspecItem
import aaa.bivizul.a31project.especdata.especstore.EspecItemStore
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class ItemMarketComponent(
    componentContext: ComponentContext,
    val especItemStore: EspecItemStore,
    itemId: Int,
) : ItemMarket, ComponentContext by componentContext {

    private val _models = MutableValue(ItemMarket.Model(itemId))
    override val models: Value<ItemMarket.Model> = _models

    override val state: StateFlow<List<EspecItem>?> = especItemStore.especItem
}