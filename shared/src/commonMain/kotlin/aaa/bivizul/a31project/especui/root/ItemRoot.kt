package aaa.bivizul.a31project.especui.root

import aaa.bivizul.a31project.especui.main.ItemMain
import aaa.bivizul.a31project.especui.screen.espec.ItemEspec
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface ItemRoot {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class EspecChild(val component: ItemEspec) : Child()
        class MainChild(val component: ItemMain) : Child()
    }
}