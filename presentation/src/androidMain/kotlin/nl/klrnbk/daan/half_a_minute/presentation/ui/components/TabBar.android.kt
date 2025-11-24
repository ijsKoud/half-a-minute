package nl.klrnbk.daan.half_a_minute.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import nl.klrnbk.daan.half_a_minute.presentation.constants.TabBarEntry
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension

@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun TabBar(
    entries: List<TabBarEntry>,
    selectedItemColor: Color,
    onSelect: (Int) -> Unit,
    selectedIdx: Int,
) {
    PrimaryTabRow(
        selectedTabIndex = selectedIdx,
        containerColor = AppTheme.colors.secondary,
        contentColor = AppTheme.colors.text.base,
        indicator = {
            TabRowDefaults.PrimaryIndicator(color = AppTheme.colors.text.base)
        },
        divider = {},
        modifier = Modifier
            .background(AppTheme.colors.secondary)
            .padding(bottom = Dimension.Padding.xlarge)
    ) {
        entries.forEachIndexed { idx, entry ->
            Tab(
                selected = selectedIdx == idx,
                onClick = { onSelect(idx) },
                icon = {
                    Icon(
                        imageVector = entry.icon,
                        contentDescription = "${entry.name} page icon",
                        tint = AppTheme.colors.text.base,
                        modifier = Modifier.size(24.dp)
                    )
                },
                text = {
                    Text(
                        text = entry.name,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                    )
                }
            )
        }
    }
}