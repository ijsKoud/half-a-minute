package nl.klrnbk.daan.half_a_minute.presentation.ui.components.select

import androidx.compose.runtime.Composable

@Composable
expect fun <T> SelectMenu(
    title: String,
    options: List<SelectMenuOption<T>>,
    selected: SelectMenuOption<T>,
    onSelect: (SelectMenuOption<T>) -> Unit
)
