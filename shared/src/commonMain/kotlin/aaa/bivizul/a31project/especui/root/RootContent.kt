package aaa.bivizul.a31project.especui.root

import aaa.bivizul.a31project.especui.main.MainContent
import aaa.bivizul.a31project.especui.screen.espec.EspecContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun RootContent(itemRoot: ItemRoot, modifier: Modifier = Modifier) {

    val childStack by itemRoot.childStack.subscribeAsState()

    Children(
        stack = childStack,
        modifier = modifier,
    ) {
        when (val child = it.instance) {
            is ItemRoot.Child.EspecChild -> EspecContent(component = child.component)
            is ItemRoot.Child.MainChild -> MainContent(itemMain = child.component)
        }
    }

}

