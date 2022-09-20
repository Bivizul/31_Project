package aaa.bivizul.a31project.especui.screen.market

import aaa.bivizul.a31project.especdata.especmodel.EspecItem
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface ItemMarket {

    val models: Value<Model>

    val state: StateFlow<List<EspecItem>?>

    data class Model(
        val selectedItemId: Int
    )

}