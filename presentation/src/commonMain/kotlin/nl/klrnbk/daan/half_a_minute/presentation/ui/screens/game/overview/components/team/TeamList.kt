package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.overview.components.team

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.IntSize
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.Team
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension

@Composable
fun TeamList(editTeamSelection: (Uuid) -> Unit, teams: List<Team>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.medium)
    ) {
        items(items = teams, key = { it.id }) { team ->
            var expanded by remember { mutableStateOf(false) }

            Column {
                TeamListHeader(
                    teamName = team.name.name,
                    isExpanded = expanded,
                    onHeaderClick = {
                        expanded =
                            expanded.not()
                    }
                )

                AnimatedVisibility(
                    visible = expanded,
                    enter = expandVertically(
                        spring(
                            stiffness = Spring.StiffnessMediumLow,
                            visibilityThreshold = IntSize.VisibilityThreshold
                        )
                    ),
                    exit = shrinkVertically()
                ) {
                    TeamListPlayerList(
                        editTeamSelection = editTeamSelection,
                        players = team.players
                    )
                }
            }
        }
    }
}
