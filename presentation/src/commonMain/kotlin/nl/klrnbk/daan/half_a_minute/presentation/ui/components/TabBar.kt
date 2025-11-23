package nl.klrnbk.daan.half_a_minute.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import nl.klrnbk.daan.half_a_minute.presentation.constants.TabBarEntry

@Composable
expect fun tabBar(
    entries: List<TabBarEntry>,
    selectedItemColor: Color,
    onSelect: (Int) -> Unit,
    selectedIdx: Int = 0,
)