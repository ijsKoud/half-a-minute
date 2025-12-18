package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.guessing.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton

@Composable
fun GuessableWordButton(toggleGuessedWord: () -> Unit, word: String, guessed: Boolean) {
    val style = if (guessed) AppTheme.colors.button.secondary else AppTheme.colors.button.primary

    StyledButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = toggleGuessedWord,
        style = style
    ) {
        Text(word)
    }
}
