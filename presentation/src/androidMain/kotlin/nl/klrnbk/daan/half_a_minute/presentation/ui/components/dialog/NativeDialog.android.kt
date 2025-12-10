package nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension

@Composable
actual fun NativeDialog(title: String?, description: String?, actions: List<DialogAction>) {
    val dimensions = Dimension.Dialog.Android
    val dismissAction = actions.firstOrNull { action ->
        action.type == DialogActionType.DISMISS
    }?.action ?: {}

    Dialog(
        onDismissRequest = dismissAction
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensions.padding),
            colors = CardColors(
                containerColor = AppTheme.colors.dialog.background.base,
                contentColor = AppTheme.colors.dialog.text.base,
                disabledContainerColor = AppTheme.colors.dialog.background.muted,
                disabledContentColor = AppTheme.colors.dialog.text.muted
            ),
            shape = RoundedCornerShape(dimensions.borderRadius)
        ) {
            Column(
                modifier = Modifier.padding(dimensions.padding),
                verticalArrangement = Arrangement.spacedBy(dimensions.contentSpacing),
                horizontalAlignment = Alignment.End
            ) {
                DialogHeader(title, description)
                DialogActions(actions)
            }
        }
    }
}

@Composable
private fun DialogHeader(title: String?, description: String?) {
    val dimensions = Dimension.Dialog.Android

    Column(
        verticalArrangement = Arrangement.spacedBy(dimensions.contentSpacing)
    ) {
        title?.let {
            Text(
                text = it,
                style = AppTheme.typography.dialog.title
            )
        }

        description?.let {
            Text(
                text = it,
                style = AppTheme.typography.dialog.description
            )
        }
    }
}

@Composable
private fun DialogActions(actions: List<DialogAction>) {
    val dimensions = Dimension.Dialog.Android

    Row(
        horizontalArrangement = Arrangement.spacedBy(dimensions.buttonSpacing)
    ) {
        actions.map {
            TextButton(
                onClick = it.action,
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    contentColor = AppTheme.colors.dialog.actions.base,
                    disabledContentColor = AppTheme.colors.dialog.actions.muted
                )
            ) {
                Text(it.name)
            }
        }
    }
}
