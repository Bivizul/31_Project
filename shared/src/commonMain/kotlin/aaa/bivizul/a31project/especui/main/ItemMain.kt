package aaa.bivizul.a31project.especui.main

import aaa.bivizul.a31project.especui.screen.conclusion.ItemConclusion
import aaa.bivizul.a31project.especui.screen.intro.ItemIntro
import aaa.bivizul.a31project.especui.screen.liberalize.ItemLiberalize
import aaa.bivizul.a31project.especui.screen.market.ItemMarket
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface ItemMain {

    val childStack: Value<ChildStack<*, Child>>

    fun onIntroTabClicked(itemId: Int)
    fun onLiberalizeTabClicked(itemId: Int)
    fun onMarketTabClicked(itemId: Int)
    fun onConclusionTabClicked(itemId: Int)

    sealed class Child {
        class IntroChild(val component: ItemIntro) : Child()
        class LiberalizeChild(val component: ItemLiberalize) : Child()
        class MarketChild(val component: ItemMarket) : Child()
        class ConclusionChild(val component: ItemConclusion) : Child()
    }

}