package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.score

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nl.klrnbk.daan.half_a_minute.domain.game.model.Scoreboard
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.score.components.GameScoreboardEndOfGame
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.score.components.GameScoreboardHeader
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.score.components.GameScoreboardNextPlayerBanner
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.score.components.GameScoreboardTeamEntry

@Composable
fun GameScoreboardScreen(
    scoreboard: Scoreboard,
    leaveTheGame: () -> Unit,
    continueToNextRound: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.xlarge),
        modifier = Modifier.fillMaxSize()
    ) {
        GameScoreboardHeader(
            score = scoreboard.previousRoundScore,
            leaveTheGame = leaveTheGame
        )

        if (scoreboard.isGameFinished) {
            GameScoreboardEndOfGame(
                teamName = scoreboard.teams.first().name,
                onClick = leaveTheGame
            )
        } else {
            GameScoreboardNextPlayerBanner(
                playerName = scoreboard.next.player.name,
                teamName = scoreboard.next.team.name,
                onClick = continueToNextRound
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.base)
        ) {
            item {
                Text(
                    style = AppTheme.typography.h2,
                    color = AppTheme.colors.text.base,
                    text = "Scoreboard"
                )
            }

            items(
                items = scoreboard.teams,
                key = { it.position }
            ) {
                GameScoreboardTeamEntry(it)
            }
        }
    }
}
