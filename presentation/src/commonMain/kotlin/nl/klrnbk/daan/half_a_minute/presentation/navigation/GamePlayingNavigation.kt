package nl.klrnbk.daan.half_a_minute.presentation.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.controller.GameControllerScreen

private const val GameIdArg = "gameId"

const val GamePlayingRoute = "/game/{$GameIdArg}/playing"

internal class GamePlayingArgs(val gameId: Uuid) {
    constructor(savedStateHandle: SavedStateHandle) :
        this(gameId = Uuid.parse(checkNotNull(savedStateHandle[GameIdArg])))
}

fun NavController.navigateToGamePlaying(gameId: Uuid) {
    this.navigate(route = GamePlayingRoute.replace("{$GameIdArg}", gameId.toString()))
}

fun NavGraphBuilder.gamePlayingScreen(navController: NavController) {
    composable(
        route = GamePlayingRoute
    ) {
        val args = GamePlayingArgs(it.savedStateHandle)
        GameControllerScreen(
            gameId = args.gameId,
            leaveTheGame = navController::navigateToLanding
        )
    }
}
