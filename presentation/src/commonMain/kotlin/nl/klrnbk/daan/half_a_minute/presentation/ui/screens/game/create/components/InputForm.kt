package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.create.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.input.TextInput
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.create.components.HostNameInputViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun InputForm(onSubmit: (String) -> Unit, viewModel: HostNameInputViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    TextInput(
        value = state.value,
        errorMessage = state.error,
        onValueChange = viewModel::onInputChanged,
        placeholder = { Text("Your name") },
        modifier = Modifier.fillMaxWidth()
    )

    StyledButton(
        modifier = Modifier.fillMaxWidth(),
        disabled = state.error != null || state.value.isEmpty(),
        onClick = { if (state.error != null) onSubmit(state.value) }
    ) {
        Text("Continue")
    }
}
