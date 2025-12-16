package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.Game
import nl.klrnbk.daan.half_a_minute.presentation.state.ErrorState
import nl.klrnbk.daan.half_a_minute.presentation.state.LoadingState
import nl.klrnbk.daan.half_a_minute.presentation.state.ResultState
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.error.ErrorScreen
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.overview.components.GameOverviewHeader
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.overview.components.team.TeamList
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.loading.LoadingScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GameOverviewScreen(
    navigateBack: () -> Unit,
    navigateToTeamSelection: (gameId: Uuid, playerId: Uuid) -> Unit,
    gameId: Uuid,
    viewModel: GameOverviewViewModel = koinViewModel()
) {
    LaunchedEffect(gameId) { viewModel.loadGameDetails(gameId) }

    val displayState by viewModel.gameState.collectAsState()
    val errorState by viewModel.errorState.collectAsState()

    when (val state = displayState) {
        is ResultState -> GameOverviewScreenContent(
            navigateBack = navigateBack,
            navigateToTeamSelection = navigateToTeamSelection,
            game = state.result,
            validationError = errorState
        )

        is LoadingState -> LoadingScreen()

        is ErrorState -> ErrorScreen(state.error)
    }
}

@Composable
fun GameOverviewScreenContent(
    navigateToTeamSelection: (gameId: Uuid, playerId: Uuid) -> Unit,
    validationError: String,
    navigateBack: () -> Unit,
    game: Game
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.xlarge),
        modifier = Modifier.fillMaxSize()
    ) {
        GameOverviewHeader(navigateBack = navigateBack)
        TeamList(
            editTeamSelection = { navigateToTeamSelection(game.id, it) },
            teams = game.teams
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.small)
        ) {
            if (validationError.isNotEmpty()) {
                Text(
                    text = validationError,
                    color = AppTheme.colors.danger
                )
            }

            StyledButton(
                modifier = Modifier.fillMaxWidth(),
                disabled = validationError.isNotEmpty(),
                style = AppTheme.colors.button.secondary,
                onClick = {}
            ) {
                Text("Let the game begin")
            }
        }
    }
}
