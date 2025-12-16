package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.overview.components.team

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import half_a_minute.presentation.generated.resources.Res
import half_a_minute.presentation.generated.resources.ic_pencil
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.extension.isEven
import nl.klrnbk.daan.half_a_minute.domain.extension.toLeaderboardIndex
import nl.klrnbk.daan.half_a_minute.domain.game.model.Player
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton
import org.jetbrains.compose.resources.painterResource

@Composable
fun TeamListPlayerList(editTeamSelection: (Uuid) -> Unit, players: List<Player>) {
    Column(
        Modifier
            .padding(top = Dimension.Spacing.medium)
            .clip(RoundedCornerShape(Dimension.BorderRadius.large))
            .background(AppTheme.colors.secondary)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        players.forEachIndexed { idx, player ->
            TeamListPlayerListEntry(
                idx = idx,
                player = player,
                editTeamSelection = {
                    editTeamSelection(player.id)
                }
            )
        }
    }
}

@Composable
fun TeamListPlayerListEntry(idx: Int, player: Player, editTeamSelection: () -> Unit) {
    val opacity = if (idx.isEven()) 0.2F else 0.0F

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimension.BorderRadius.medium))
            .background(AppTheme.colors.tertiary.copy(opacity)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${idx.toLeaderboardIndex()}. ${player.name}",
            modifier = Modifier.padding(start = Dimension.Padding.medium),
            style = AppTheme.typography.body,
            color = AppTheme.colors.text.base
        )

        StyledButton(onClick = editTeamSelection, textOnly = true) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(Res.drawable.ic_pencil),
                contentDescription = "Edit ${player.name}'s team selection",
                tint = AppTheme.colors.text.base
            )
        }
    }
}
