package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.invite.components.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.Player
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton

@Composable
fun PlayerListForm(
    players: List<Player>,
    isDisabled: (Uuid) -> Boolean,
    onDelete: (Uuid) -> Unit,
    onSubmit: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.large)
    ) {
        Text(
            text = "${players.size}/8 players",
            color = AppTheme.colors.text.base,
            style = AppTheme.typography.body
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            players.map {
                PlayerListEntry(
                    id = it.id,
                    name = it.name,
                    onDeleteClick = onDelete,
                    disabled = isDisabled(it.id)
                )
            }
        }

        StyledButton(
            modifier = Modifier.fillMaxWidth(),
            disabled = players.size <= 1,
            onClick = onSubmit,
            style = AppTheme.colors.button.secondary
        ) {
            Text("Choose the teams")
        }
    }
}
