package aaa.bivizul.a31project.especui.main

import aaa.bivizul.a31project.especdata.especutil.Especcon.TAB_FOUR
import aaa.bivizul.a31project.especdata.especutil.Especcon.TAB_ONE
import aaa.bivizul.a31project.especdata.especutil.Especcon.TAB_THREE
import aaa.bivizul.a31project.especdata.especutil.Especcon.TAB_TWO
import aaa.bivizul.a31project.especui.screen.conclusion.ConclusionContent
import aaa.bivizul.a31project.especui.screen.intro.IntroContent
import aaa.bivizul.a31project.especui.screen.liberalize.LiberalizeContent
import aaa.bivizul.a31project.especui.screen.market.MarketContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.*
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun MainContent(
    itemMain: ItemMain,
    modifier: Modifier = Modifier
) {

    val childStack by itemMain.childStack.subscribeAsState()
    val activeComponent = childStack.active.instance

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Children(
            stack = childStack,
            modifier = Modifier.weight(weight = 1F),
            animation = tabAnimation(),
        ) {
            when (val child = it.instance) {
                is ItemMain.Child.IntroChild -> IntroContent(
                    component = child.component,
                    modifier = Modifier.fillMaxSize()
                )
                is ItemMain.Child.LiberalizeChild -> LiberalizeContent(
                    component = child.component,
                    modifier = Modifier.fillMaxSize()
                )
                is ItemMain.Child.MarketChild -> MarketContent(
                    component = child.component,
                    modifier = Modifier.fillMaxSize()
                )
                is ItemMain.Child.ConclusionChild -> ConclusionContent(
                    component = child.component,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        BottomNavigation(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.primary,
            elevation = 14.dp
        ) {
            BottomNavigationItem(
                selected = activeComponent is ItemMain.Child.IntroChild,
                onClick = { itemMain.onIntroTabClicked(TAB_ONE) },
                icon = { TextBottomTab(text = "Intro") },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.onPrimary,
            )

            BottomNavigationItem(
                selected = activeComponent is ItemMain.Child.LiberalizeChild,
                onClick = { itemMain.onLiberalizeTabClicked(TAB_TWO) },
                icon = { TextBottomTab(text = "Liberalize") },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.onPrimary,
            )

            BottomNavigationItem(
                selected = activeComponent is ItemMain.Child.MarketChild,
                onClick = { itemMain.onMarketTabClicked(TAB_THREE) },
                icon = { TextBottomTab(text = "Market") },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.onPrimary,
            )

            BottomNavigationItem(
                selected = activeComponent is ItemMain.Child.ConclusionChild,
                onClick = { itemMain.onConclusionTabClicked(TAB_FOUR) },
                icon = { TextBottomTab(text = "Conclusion") },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.onPrimary,
            )
        }
    }
}

@Composable
fun TextBottomTab(
    text: String
) {
    Text(
        text = text,
        modifier = Modifier.padding(2.dp),
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
    )
}

@OptIn(ExperimentalDecomposeApi::class)
@Composable
private fun tabAnimation(): StackAnimation<Any, ItemMain.Child> =
    stackAnimation { child, otherChild, direction ->
        val index = child.instance.index
        val otherIndex = otherChild.instance.index
        val anim = slide()
        if ((index > otherIndex) == direction.isEnter) anim else anim.flipSide()
    }

private val ItemMain.Child.index: Int
    get() =
        when (this) {
            is ItemMain.Child.IntroChild -> 0
            is ItemMain.Child.LiberalizeChild -> 1
            is ItemMain.Child.MarketChild -> 2
            is ItemMain.Child.ConclusionChild -> 3
        }

@OptIn(ExperimentalDecomposeApi::class)
private fun StackAnimator.flipSide(): StackAnimator =
    StackAnimator { direction, onFinished, content ->
        invoke(
            direction = direction.flipSide(),
            onFinished = onFinished,
            content = content,
        )
    }

@Suppress("OPT_IN_USAGE")
private fun Direction.flipSide(): Direction =
    when (this) {
        Direction.ENTER_FRONT -> Direction.ENTER_BACK
        Direction.EXIT_FRONT -> Direction.EXIT_BACK
        Direction.ENTER_BACK -> Direction.ENTER_FRONT
        Direction.EXIT_BACK -> Direction.EXIT_FRONT
    }