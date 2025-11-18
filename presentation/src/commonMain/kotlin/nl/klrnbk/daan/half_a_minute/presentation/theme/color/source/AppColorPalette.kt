package nl.klrnbk.daan.half_a_minute.presentation.theme.color.source

import androidx.compose.ui.graphics.Color
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition.StaticColor

internal object AppColorPalette {
    object Static {
        object Blurple: StaticColor {
            override val darkMode = true
            override val primary = Color(color = 0xFF_484BAA)
            override val secondary = Color(color = 0xFF_676AC8)
            override val tertiary = Color(color = 0xFF_111350)
            override val black = Color(color = 0xFF_000000)
            override val white = Color(color = 0xFF_FFFFFF)
            override val danger = Color(color = 0xFF_E06F6C)
        }

        object Green: StaticColor {
            override val darkMode = true
            override val primary = Color(color = 0xFF_55AA48)
            override val secondary = Color(color = 0xFF_2D7937)
            override val tertiary = Color(color = 0xFF_15571E)
            override val black = Color(color = 0xFF_000000)
            override val white = Color(color = 0xFF_FFFFFF)
            override val danger = Color(color = 0xFF_C23D39)
        }
    }
}
