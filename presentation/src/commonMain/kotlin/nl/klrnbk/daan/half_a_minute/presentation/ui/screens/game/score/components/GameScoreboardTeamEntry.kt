package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.score.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import nl.klrnbk.daan.half_a_minute.domain.game.model.ScoreboardTeam
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension

@Composable
fun GameScoreboardTeamEntry(team: ScoreboardTeam) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimension.BorderRadius.large))
            .background(AppTheme.colors.secondary)
            .padding(
                PaddingValues(
                    horizontal = Dimension.Padding.large,
                    vertical = Dimension.Padding.medium
                )
            )
    ) {
        Text(
            modifier = Modifier
                .clip(RoundedCornerShape(Dimension.BorderRadius.medium))
                .background(AppTheme.colors.tertiary)
                .padding(
                    PaddingValues(
                        horizontal = Dimension.Padding.large,
                        vertical = Dimension.Padding.medium
                    )
                ),
            color = AppTheme.colors.text.base,
            text = team.toPositionString()
        )

        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                style = AppTheme.typography.h2,
                color = AppTheme.colors.text.base,
                text = "Team ${team.name.name}"
            )

            Text(
                style = AppTheme.typography.h3,
                color = AppTheme.colors.tertiary,
                text = team.toScoreString()
            )
        }
    }
}
