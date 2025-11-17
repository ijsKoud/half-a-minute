package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.example.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.example.ExampleViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ExampleScreen(
    viewModel: ExampleViewModel = koinViewModel(),
) {
    val state = viewModel.platformMessage.collectAsState().value

    state?.let {
        ExampleScreenContent(
            state = it,
        )
    }
}
