package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.overview.components.team

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import half_a_minute.presentation.generated.resources.Res
import half_a_minute.presentation.generated.resources.ic_arrow_head_left
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import org.jetbrains.compose.resources.painterResource

@Composable
fun TeamListHeader(
    teamName: String,
    teamSize: Int,
    isExpanded: Boolean,
    onHeaderClick: () -> Unit
) {
    val contentDescription = "${if (isExpanded) "Close" else "Open"} the player list of team $teamName"
    val degrees by animateFloatAsState(
        if (isExpanded) HEADER_OPEN_STATE_DEGREES else HEADER_CLOSED_STATE_DEGREES
    )

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(Dimension.BorderRadius.large))
            .background(AppTheme.colors.secondary)
            .clickable(onClick = onHeaderClick)
            .fillMaxWidth()
            .padding(Dimension.Padding.large),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Team $teamName",
            style = AppTheme.typography.body,
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.tertiary
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(Dimension.Spacing.medium)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(999.dp))
                    .background(AppTheme.colors.tertiary)
                    .size(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = teamSize.toString(),
                    color = AppTheme.colors.text.base
                )
            }

            Icon(
                painterResource(Res.drawable.ic_arrow_head_left),
                contentDescription = contentDescription,
                modifier = Modifier.rotate(degrees),
                tint = AppTheme.colors.tertiary
            )
        }
    }
}
