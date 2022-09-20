package aaa.bivizul.a31project.especui.root

import aaa.bivizul.a31project.especdata.especstore.EspecStore
import aaa.bivizul.a31project.especui.main.ItemMain
import aaa.bivizul.a31project.especui.main.ItemMainComponent
import aaa.bivizul.a31project.especui.screen.espec.ItemEspec
import aaa.bivizul.a31project.especui.screen.espec.ItemEspecComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

class ItemRootComponent constructor(
    componentContext: ComponentContext,
    private val context: Any
) : ItemRoot, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    val especStore = EspecStore()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.Espec,
            handleBackButton = true,
            childFactory = ::createChild,
        )

    override val childStack: Value<ChildStack<*, ItemRoot.Child>> get() = stack

    private fun createChild(config: Config, componentContext: ComponentContext): ItemRoot.Child =
        when (config) {
            is Config.Espec -> ItemRoot.Child.EspecChild(itemEspec(componentContext))
            is Config.Main -> ItemRoot.Child.MainChild(itemMain(componentContext))
        }

    private fun itemEspec(componentContext: ComponentContext): ItemEspec =
        ItemEspecComponent(
            componentContext = componentContext,
            context = context,
            apostStore = especStore,
            onReplaceCur = {
                navigation.replaceCurrent(Config.Main)
            },
        )

    private fun itemMain(componentContext: ComponentContext): ItemMain =
        ItemMainComponent(
            componentContext = componentContext,
        )

    private sealed class Config : Parcelable {
        @Parcelize
        object Espec : Config()

        @Parcelize
        object Main : Config()
    }
}
