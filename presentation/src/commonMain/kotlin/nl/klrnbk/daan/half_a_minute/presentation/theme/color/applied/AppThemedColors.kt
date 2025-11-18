package nl.klrnbk.daan.half_a_minute.presentation.theme.color.applied

import androidx.compose.runtime.staticCompositionLocalOf
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition.AppColors
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition.ButtonsGroup
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition.InputsGroup
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition.Interaction
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition.InteractionColors
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition.TextColors
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.source.AppColorPalette

internal val LocalColors = staticCompositionLocalOf { appColors[0] }

internal val appColorGroups = mapOf(
    "blurple" to AppColorPalette.Static.Blurple,
    "green" to AppColorPalette.Static.Green,
)
internal val appColors = appColorGroups.map {
        (name, colors) ->
            AppColors(
                name = name,
                darkMode = colors.darkMode,
                primary = colors.primary,
                secondary = colors.secondary,
                tertiary = colors.tertiary,
                black = colors.black,
                white = colors.white,
                danger = colors.danger,

                text = TextColors(
                    base = colors.white
                ),
                input = InputsGroup(
                    default = Interaction(
                        background = InteractionColors(
                            base = colors.secondary,
                            muted = colors.secondary.copy(alpha = 0.5F)
                        ),
                        text = InteractionColors(
                            base = colors.tertiary,
                            muted = colors.tertiary.copy(alpha = 0.5F)
                        )
                    ),
                    danger = Interaction(
                        background = InteractionColors(
                            base = colors.danger,
                            muted = colors.danger.copy(alpha = 0.5F)
                        ),
                        text = InteractionColors(
                            base = colors.danger,
                            muted = colors.danger.copy(alpha = 0.5F)

                        )
                    )
                ),
                button = ButtonsGroup(
                    primary = Interaction(
                        background = InteractionColors(
                            base = colors.secondary,
                            muted = colors.secondary.copy(alpha = 0.4F)
                        ),
                        text = InteractionColors(
                            base = colors.white,
                            muted = colors.white.copy(alpha = 0.5F)
                        )
                    ),
                    secondary = Interaction(
                        background = InteractionColors(
                            base = colors.tertiary,
                            muted = colors.tertiary.copy(alpha = 0.4F)
                        ),
                        text = InteractionColors(
                            base = colors.white,
                            muted = colors.white.copy(alpha = 0.5F)
                        )
                    ),
                    danger = Interaction(
                        background = InteractionColors(
                            base = colors.danger,
                            muted = colors.danger.copy(alpha = 0.5F)
                        ),
                        text = InteractionColors(
                            base = colors.white,
                            muted = colors.white.copy(alpha = 0.5F)

                        )
                    )
                )
            )
}
