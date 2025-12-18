package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.overview.components.settings

import nl.klrnbk.daan.half_a_minute.presentation.ui.components.select.SelectMenuOption

val gamePointsOptions = listOf(25, 50, 75, 100).map {
    SelectMenuOption(name = "${it}pts", value = it)
}
val gamePointsDefaultOption = gamePointsOptions[0]

val wordsPerRoundOptions = listOf(3, 5, 8).map { SelectMenuOption(name = "$it", value = it) }
val wordsPerRoundDefaultOption = wordsPerRoundOptions[1]
