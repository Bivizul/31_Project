package aaa.bivizul.a31project.especui.main

import aaa.bivizul.a31project.especdata.especstore.EspecItemStore
import aaa.bivizul.a31project.especdata.especutil.Especcon.TAB_ONE
import aaa.bivizul.a31project.especui.screen.conclusion.ItemConclusionComponent
import aaa.bivizul.a31project.especui.screen.intro.ItemIntroComponent
import aaa.bivizul.a31project.especui.screen.liberalize.ItemLiberalizeComponent
import aaa.bivizul.a31project.especui.screen.market.ItemMarketComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

class ItemMainComponent(
    componentContext: ComponentContext,
) : ItemMain, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    private val especItemStore = EspecItemStore()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.Intro(itemId = TAB_ONE),
            childFactory = ::createChild,
        )

    override val childStack: Value<ChildStack<*, ItemMain.Child>> = stack

    override fun onIntroTabClicked(itemId: Int) {
        navigation.bringToFront(Config.Intro(itemId))
    }

    override fun onLiberalizeTabClicked(itemId: Int) {
        navigation.bringToFront(Config.Liberalize(itemId))
    }

    override fun onMarketTabClicked(itemId: Int) {
        navigation.bringToFront(Config.Market(itemId))
    }

    override fun onConclusionTabClicked(itemId: Int) {
        navigation.bringToFront(Config.Conclusion(itemId))
    }

    private fun createChild(config: Config, componentContext: ComponentContext): ItemMain.Child =
        when (config) {
            is Config.Intro -> ItemMain.Child.IntroChild(
                ItemIntroComponent(
                    componentContext = componentContext,
                    especItemStore = especItemStore,
                    itemId = config.itemId
                )
            )
            is Config.Liberalize -> ItemMain.Child.LiberalizeChild(
                ItemLiberalizeComponent(
                    componentContext = componentContext,
                    especItemStore = especItemStore,
                    itemId = config.itemId
                )
            )
            is Config.Market -> ItemMain.Child.MarketChild(
                ItemMarketComponent(
                    componentContext = componentContext,
                    especItemStore = especItemStore,
                    itemId = config.itemId
                )
            )
            is Config.Conclusion -> ItemMain.Child.ConclusionChild(
                ItemConclusionComponent(
                    componentContext = componentContext,
                    especItemStore = especItemStore,
                    itemId = config.itemId
                )
            )
        }

    private sealed class Config : Parcelable {
        @Parcelize
        data class Intro(val itemId: Int) : Config()

        @Parcelize
        data class Liberalize(val itemId: Int) : Config()

        @Parcelize
        data class Market(val itemId: Int) : Config()

        @Parcelize
        data class Conclusion(val itemId: Int) : Config()
    }

}