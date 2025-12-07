package nl.klrnbk.daan.half_a_minute.presentation.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.invite.GameInviteScreen

private const val GameIdArg = "gameId"
const val GameInviteRoute = "/invite/{$GameIdArg}"

internal class GameInviteArgs(val gameId: Uuid) {
    constructor(savedStateHandle: SavedStateHandle) :
        this(gameId = Uuid.parse(checkNotNull(savedStateHandle[GameIdArg])))
}

fun NavController.navigateToGameInvite(gameId: Uuid) {
    this.navigate(route = GameInviteRoute.replace("{$GameIdArg}", gameId.toString()))
}

fun NavGraphBuilder.gameInviteScreen(navController: NavController) {
    composable(
        route = GameInviteRoute
    ) {
        val args = GameInviteArgs(it.savedStateHandle)
        GameInviteScreen(
            gameId = args.gameId,
            navigateBack = navController::popBackStack
        )
    }
}
