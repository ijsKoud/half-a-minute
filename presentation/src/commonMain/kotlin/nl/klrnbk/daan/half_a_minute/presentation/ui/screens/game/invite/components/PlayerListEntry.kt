package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.invite.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.input.TextInput
import nl.klrnbk.daan.half_a_minute.presentation.ui.icons.CloseIcon

@Composable
fun PlayerListEntry(id: Uuid, name: String, disabled: Boolean, onDeleteClick: (Uuid) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(Dimension.Spacing.large),
        modifier = Modifier.fillMaxWidth()
    ) {
        TextInput(
            value = name,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.weight(1f)
        )

        StyledButton(
            style = AppTheme.colors.button.danger,
            disabled = disabled,
            onClick = { onDeleteClick(id) },
            modifier = Modifier.height(55.dp)
        ) {
            Icon(
                imageVector = CloseIcon,
                contentDescription = "Remove player $name",
                tint = AppTheme.colors.white,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
