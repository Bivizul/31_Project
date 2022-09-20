package aaa.bivizul.a31project.especui.screen.market

import aaa.bivizul.a31project.especui.especwidget.Especcp
import aaa.bivizul.a31project.especui.screen.screentab.ScreenTab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun MarketContent(
    component: ItemMarket,
    modifier: Modifier = Modifier
) {

    val especItemList by component.state.collectAsState()
    val model by component.models.subscribeAsState()

    if (especItemList != null) {
        especItemList?.let { list ->
            list[model.selectedItemId - 1].let { item ->
                ScreenTab(
                    modifier = modifier,
                    item = item
                )
            }
        }
    } else {
        Especcp()
    }

}