package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.invite.components.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog.DialogAction
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog.DialogActionType
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog.NativeDialog
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.input.TextInput
import nl.klrnbk.daan.half_a_minute.presentation.ui.icons.CloseIcon

@Composable
fun PlayerListEntry(id: Uuid, name: String, disabled: Boolean, onDeleteClick: (Uuid) -> Unit) {
    var dialogState by remember { mutableStateOf(false) }
    fun closeDialog() {
        dialogState = false
    }
    fun openDialog() {
        dialogState = true
    }

    if (dialogState) {
        NativeDialog(
            title = "Remove this player?",
            description = "Are you sure you want to remove $name from the game?",
            actions = listOf(
                DialogAction(
                    name = "Cancel",
                    type = DialogActionType.DISMISS,
                    action = ::closeDialog
                ),
                DialogAction(
                    name = "Remove",
                    type = DialogActionType.DESTRUCTIVE,
                    action = {
                        closeDialog()
                        onDeleteClick(id)
                    }
                )
            )
        )
    }

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
            onClick = ::openDialog,
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
