package nl.klrnbk.daan.half_a_minute.presentation.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.teams.controller.TeamSelectionControllerScreen
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.teams.selection.TeamSelectionScreen

// Invite stage -> team selection: 'controller' will handle the routing

// Pre-game stage -> team selection: compose will handle routing
// and move back to original page after selection using provided game id

private const val GameIdArg = "gameId"

const val GameTeamSelectionRoute = "/game/{$GameIdArg}/teams/selection/all"

internal class GameTeamSelectionArgs(val gameId: Uuid) {
    constructor(savedStateHandle: SavedStateHandle) :
        this(gameId = Uuid.parse(checkNotNull(savedStateHandle[GameIdArg])))
}

fun NavController.navigateToGameTeamSelection(gameId: Uuid) {
    this.navigate(route = GameTeamSelectionRoute.replace("{$GameIdArg}", gameId.toString()))
}

fun NavGraphBuilder.gameTeamSelectionScreen(navController: NavController) {
    composable(
        route = GameTeamSelectionRoute
    ) {
        val args = GameTeamSelectionArgs(it.savedStateHandle)
        TeamSelectionControllerScreen(
            gameId = args.gameId,
            navigateBack = navController::popBackStack,
            navigateHome = navController::navigateToLanding
        )
    }
}
