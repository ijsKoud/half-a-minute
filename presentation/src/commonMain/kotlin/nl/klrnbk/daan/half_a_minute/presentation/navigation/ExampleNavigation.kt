package nl.klrnbk.daan.half_a_minute.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.example.screen.ExampleScreen

const val ExampleRoute = "example"

fun NavController.navigateToExample() {
    this.navigate(route = ExampleRoute)
}

fun NavGraphBuilder.exampleScreen() {
    composable(
        route = ExampleRoute,
    ) {
        ExampleScreen()
    }
}
