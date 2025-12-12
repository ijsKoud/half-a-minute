package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.invite.components.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.input.TextInput
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun InputForm(
    onSubmit: (String) -> Unit,
    disabled: Boolean,
    viewModel: FriendNameInputViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    fun preOnSubmit() {
        onSubmit(state.value)
        viewModel.onInputChanged("")
    }

    Column {
        TextInput(
            value = state.value,
            errorMessage = state.error,
            onValueChange = viewModel::onInputChanged,
            placeholder = { Text("Your friends name") },
            modifier = Modifier.fillMaxWidth()
        )

        StyledButton(
            modifier = Modifier.fillMaxWidth(),
            disabled = disabled || state.error != null || state.value.isEmpty(),
            onClick = ::preOnSubmit,
            style = AppTheme.colors.button.secondary
        ) {
            Text("Add friend")
        }
    }
}
