package nl.klrnbk.daan.half_a_minute.presentation.ui.components.select

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.input.TextInput

@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun <T> SelectMenu(
    title: String,
    options: List<SelectMenuOption<T>>,
    selected: SelectMenuOption<T>,
    onSelect: (SelectMenuOption<T>) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        onExpandedChange = { isExpanded = isExpanded.not() },
        expanded = isExpanded
    ) {
        TextInput(
            modifier = Modifier
                .menuAnchor(type = MenuAnchorType.PrimaryNotEditable)
                .fillMaxWidth(),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            value = "$title: ${selected.name}",
            onValueChange = {},
            readOnly = true
        )

        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
            containerColor = AppTheme.colors.secondary,
            shape = RoundedCornerShape(Dimension.BorderRadius.medium)
        ) {
            options.forEach {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = it.name,
                            style = AppTheme.typography.body,
                            color = AppTheme.colors.tertiary
                        )
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    onClick = {
                        onSelect(it)
                        isExpanded = false
                    }
                )
            }
        }
    }
}
