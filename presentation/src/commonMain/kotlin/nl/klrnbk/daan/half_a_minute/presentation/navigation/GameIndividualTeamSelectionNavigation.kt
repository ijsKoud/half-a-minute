package nl.klrnbk.daan.half_a_minute.presentation.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.teams.individual.IndividualTeamSelectionScreen

private const val GameIdArg = "gameId"
private const val PlayerIdArg = "playerId"

const val GameIndividualTeamSelectionRoute = "/game/{$GameIdArg}/teams/selection/{$PlayerIdArg}"

internal class GameIndividualTeamSelectionArgs(val gameId: Uuid, val playerId: Uuid) {
    constructor(savedStateHandle: SavedStateHandle) :
        this(
            gameId = Uuid.parse(checkNotNull(savedStateHandle[GameIdArg])),
            playerId = Uuid.parse(checkNotNull(savedStateHandle[PlayerIdArg]))
        )
}

fun NavController.navigateToIndividualTeamSelection(gameId: Uuid, playerId: Uuid) {
    val route = GameIndividualTeamSelectionRoute
        .replace("{$GameIdArg}", gameId.toString())
        .replace("{$PlayerIdArg}", playerId.toString())
    this.navigate(route = route)
}

fun NavGraphBuilder.gameIndividualTeamSelection(navController: NavController) {
    composable(
        route = GameIndividualTeamSelectionRoute
    ) {
        val args = GameIndividualTeamSelectionArgs(it.savedStateHandle)
        IndividualTeamSelectionScreen(
            gameId = args.gameId,
            playerId = args.playerId,
            navigateBack = navController::popBackStack,
            navigateHome = navController::navigateToLanding,
            navigateToReview = { navController.navigateToGameOverview(args.gameId) }
        )
    }
}
