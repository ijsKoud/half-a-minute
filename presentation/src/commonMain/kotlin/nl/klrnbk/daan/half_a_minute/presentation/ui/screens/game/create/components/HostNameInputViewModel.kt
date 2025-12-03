package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.create.components

import nl.klrnbk.daan.half_a_minute.presentation.ui.components.input.TextInputViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HostNameInputViewModel : TextInputViewModel() {
    override fun validateInputAndReturnError(input: String): String? {
        if (input.isEmpty()) return "Your name cannot be empty"
        if (input.length > 20) return "Your name should stay under the 20 character limit"

        return null
    }
}
