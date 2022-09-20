package aaa.bivizul.a31project.especui.screen.screentab

import aaa.bivizul.a31project.especdata.especmodel.EspecItem
import aaa.bivizul.a31project.especdata.especmodel.Impact
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenTab(
    modifier: Modifier,
    item: EspecItem
) {
    LazyColumn(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        item {
            Text(
                text = item.espectitle,
                style = MaterialTheme.typography.h5
            )
            Text(
                text = item.especdescription,
                style = MaterialTheme.typography.body1
            )
        }

        if (item.impacts != emptyList<Impact>()) {
            items(item.impacts) { itemImpact ->
                Text(
                    text = itemImpact.especsubtitle,
                    modifier = modifier.padding(4.dp),
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = itemImpact.especsubdescription,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }

}

