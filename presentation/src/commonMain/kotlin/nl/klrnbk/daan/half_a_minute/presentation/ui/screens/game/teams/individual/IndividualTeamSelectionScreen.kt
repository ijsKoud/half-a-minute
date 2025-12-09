package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.teams.individual

import androidx.compose.runtime.Composable
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.teams.selection.TeamSelectionScreen
import nl.klrnbk.daan.half_a_minute.presentation.ui.utils.OnLifecycleEvent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun IndividualTeamSelectionScreen(
    navigateBack: () -> Unit,
    navigateHome: () -> Unit,
    navigateToReview: () -> Unit,
    playerId: Uuid,
    gameId: Uuid,
    viewModel: IndividualTeamSelectionViewModel = koinViewModel()
) {
    OnLifecycleEvent(
        onCreate = {
            viewModel.navigateBack = navigateBack
            viewModel.navigateForward = navigateToReview
            viewModel.loadGameDetails(gameId)
        }
    )

    TeamSelectionScreen(
        navigateBack = navigateBack,
        navigateHome = navigateHome,
        playerId = playerId,
        isTeamDisabled = { false },
        maxAmountOfTeams = viewModel.getMaxAmountOfTeams(),
        onSubmit = viewModel::setTeamAndContinue
    )
}
