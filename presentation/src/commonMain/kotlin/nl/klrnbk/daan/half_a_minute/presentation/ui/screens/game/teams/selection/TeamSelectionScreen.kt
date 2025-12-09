package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.teams.selection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.Player
import nl.klrnbk.daan.half_a_minute.domain.game.model.TeamName
import nl.klrnbk.daan.half_a_minute.presentation.state.ErrorState
import nl.klrnbk.daan.half_a_minute.presentation.state.LoadingState
import nl.klrnbk.daan.half_a_minute.presentation.state.ResultState
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.components.GoBackButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.teams.selection.model.TeamState
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TeamSelectionScreen(
    navigateBack: () -> Unit,
    navigateHome: () -> Unit,
    onSubmit: (playerId: Uuid, teamName: TeamName) -> Unit,
    isTeamDisabled: (TeamName) -> Boolean,
    playerId: Uuid,
    maxAmountOfTeams: Int,
    viewModel: TeamSelectionScreenViewModel = koinViewModel()
) {
    LaunchedEffect(playerId) {
        viewModel.loadPlayerDetails(playerId)
        viewModel.updateTeams()

        viewModel.navigateHome = navigateHome
    }

    LaunchedEffect(maxAmountOfTeams) {
        viewModel.setMaxAmountOfTeams(maxAmountOfTeams)
        viewModel.isTeamDisabled = isTeamDisabled
    }

    val playerState by viewModel.playerState.collectAsState()
    val teamsState by viewModel.teamsState.collectAsState()

    when (val state = playerState) {
        is ResultState -> TeamSelectionScreenContent(
            navigateBack = navigateBack,
            onSubmit = onSubmit,
            player = state.result,
            teams = teamsState
        )

        is LoadingState -> null

        is ErrorState -> null
    }
}

@Composable
private fun TeamSelectionScreenContent(
    player: Player,
    teams: List<TeamState>,
    navigateBack: () -> Unit,
    onSubmit: (playerId: Uuid, teamName: TeamName) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.xxlarge)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                GoBackButton(
                    modifier = Modifier,
                    onClick = navigateBack
                )
            }

            Text(
                color = AppTheme.colors.text.base,
                style = AppTheme.typography.h1,
                textAlign = TextAlign.Center,
                text =
                    buildAnnotatedString {
                        append("Which side are you on ")
                        withStyle(
                            style = SpanStyle(color = AppTheme.colors.tertiary)
                        ) { append(player.name) }
                        append("?")
                    }
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.small * 2)
        ) {
            teams.map {
                StyledButton(
                    disabled = it.disabled,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onSubmit(player.id, it.name) }
                ) {
                    Text(it.name.name)
                }
            }
        }
    }
}
