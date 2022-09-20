package aaa.bivizul.a31project.especui.screen.conclusion

import aaa.bivizul.a31project.especdata.especmodel.EspecItem
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface ItemConclusion {

    val models: Value<Model>

    val state: StateFlow<List<EspecItem>?>

    data class Model(
        val selectedItemId: Int
    )

}