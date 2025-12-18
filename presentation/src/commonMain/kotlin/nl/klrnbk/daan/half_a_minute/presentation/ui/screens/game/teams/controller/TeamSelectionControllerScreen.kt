package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.teams.controller

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.teams.selection.TeamSelectionScreen
import nl.klrnbk.daan.half_a_minute.presentation.ui.utils.OnLifecycleEvent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TeamSelectionControllerScreen(
    gameId: Uuid,
    navigateBack: () -> Unit,
    navigateHome: () -> Unit,
    navigateToOverview: () -> Unit,
    viewModel: TeamSelectionControllerViewModel = koinViewModel()
) {
    OnLifecycleEvent(
        onCreate = {
            viewModel.loadGameDetails(gameId)
            viewModel.clearSelection(gameId)

            viewModel.navigateBack = navigateBack
            viewModel.navigateForward = navigateToOverview
        }
    )

    val gameState by viewModel.gameState.collectAsState()
    if (gameState == null) return

    val activePlayerState by viewModel.activePlayerState.collectAsState()
    if (activePlayerState == null) return

    TeamSelectionScreen(
        playerId = activePlayerState!!.id,
        maxAmountOfTeams = viewModel.getMaxAmountOfTeams(),
        isTeamDisabled = viewModel::isTeamDisabled,
        navigateBack = navigateBack,
        navigateHome = navigateHome,
        onSubmit = viewModel::setTeamAndContinue
    )
}
