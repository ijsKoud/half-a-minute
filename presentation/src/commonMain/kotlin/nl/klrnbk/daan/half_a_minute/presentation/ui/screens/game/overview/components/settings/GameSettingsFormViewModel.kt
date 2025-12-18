package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.overview.components.settings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.select.SelectMenuOption
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class GameSettingsFormViewModel : ViewModel() {
    private val pointsGoalMutableState = MutableStateFlow(gamePointsDefaultOption)
    val pointsGoalState = pointsGoalMutableState.asStateFlow()

    private val wordsPerRoundMutableState = MutableStateFlow(wordsPerRoundDefaultOption)
    val wordsPerRoundState = wordsPerRoundMutableState.asStateFlow()

    private val categoriesMutableState = MutableStateFlow(gamePointsOptions[0])
    val categoriesState = categoriesMutableState.asStateFlow()

    fun updatePointsGoalOption(option: SelectMenuOption<Int>) =
        pointsGoalMutableState.update { option }
    fun updateWordsPerRoundOption(option: SelectMenuOption<Int>) =
        wordsPerRoundMutableState.update { option }
}
