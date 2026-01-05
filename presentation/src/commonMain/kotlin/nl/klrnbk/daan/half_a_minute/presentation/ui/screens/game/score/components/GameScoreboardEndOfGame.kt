package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.score.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import nl.klrnbk.daan.half_a_minute.domain.game.model.TeamName
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.icons.CloseIcon

@Composable
fun GameScoreboardEndOfGame(teamName: TeamName, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimension.BorderRadius.medium))
            .background(AppTheme.colors.secondary)
            .padding(
                PaddingValues(
                    horizontal = Dimension.Padding.large,
                    vertical = Dimension.Padding.medium
                )
            )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.small)
        ) {
            Text(
                style = AppTheme.typography.h2,
                color = AppTheme.colors.text.base,
                text = "The game is over"
            )

            Text(
                style = AppTheme.typography.h3,
                color = AppTheme.colors.tertiary,
                text = "Team ${teamName.name} has won!"
            )
        }

        StyledButton(
            modifier = Modifier.width(44.dp),
            onClick = onClick,
            style = AppTheme.colors.button.secondary
        ) {
            Icon(
                imageVector = CloseIcon,
                contentDescription = "Exit the game",
                tint = AppTheme.colors.white,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
