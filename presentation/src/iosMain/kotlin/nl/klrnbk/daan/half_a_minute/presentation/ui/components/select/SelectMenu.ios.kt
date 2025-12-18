package nl.klrnbk.daan.half_a_minute.presentation.ui.components.select

import LocalNativeViewFactory
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.infiniteretry.snizzors.SnizzorsUIViewController
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.ui.helpers.toUIColor

@Composable
actual fun <T> SelectMenu(
    title: String,
    options: List<SelectMenuOption<T>>,
    selected: SelectMenuOption<T>,
    onSelect: (SelectMenuOption<T>) -> Unit
) {
    val factories = LocalNativeViewFactory.current
    val colors = SelectMenuColors(
        contentColor = AppTheme.colors.text.base.toUIColor(),
        backgroundColor = AppTheme.colors.secondary.toUIColor()
    )

    SnizzorsUIViewController(
        modifier = Modifier.height(44.dp).fillMaxWidth(),
        update = {},
        factory = {
            factories.selectMenuFactory(
                title = title,
                colors = colors,
                options = options,
                selected = selected,
                onSelect = onSelect
            )
        }
    )
}
