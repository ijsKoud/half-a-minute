package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.guessing.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension

@Composable
fun GuessableWordsList(
    words: List<String>,
    guessedWords: List<String>,
    wordSelectionTime: Boolean,
    toggleGuessedWord: (String) -> Unit
) {
    val modifier = if (wordSelectionTime) {
        Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(Dimension.BorderRadius.medium))
            .background(AppTheme.colors.secondary)
            .padding(Dimension.Padding.large)
    } else {
        Modifier.fillMaxWidth()
    }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.small),
        modifier = modifier
    ) {
        items(items = words, key = { it }) {
            GuessableWordButton(
                word = it,
                guessed = guessedWords.contains(it),
                toggleGuessedWord = { toggleGuessedWord(it) }
            )
        }
    }
}
