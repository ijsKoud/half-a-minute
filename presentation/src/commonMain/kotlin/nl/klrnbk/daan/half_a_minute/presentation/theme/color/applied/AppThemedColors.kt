package nl.klrnbk.daan.half_a_minute.presentation.theme.color.applied

import androidx.compose.runtime.staticCompositionLocalOf
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition.AppColors
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition.Components
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition.PlatformMessage
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.source.AppColorPalette

internal val LocalColors = staticCompositionLocalOf { appColorsLight }

internal val appColorsLight = AppColors(
    background = AppColorPalette.Solid.white,
    text = AppColorPalette.Solid.black,
    components = Components(
        platformMessage = PlatformMessage(
            iosBackground = AppColorPalette.Components.PlatformMessage.ios,
            androidBackground = AppColorPalette.Components.PlatformMessage.android,
        ),
    ),
)

internal val appColorsDark = AppColors(
    background = AppColorPalette.Solid.black,
    text = AppColorPalette.Solid.white,
    components = Components(
        platformMessage = PlatformMessage(
            iosBackground = AppColorPalette.Components.PlatformMessage.ios,
            androidBackground = AppColorPalette.Components.PlatformMessage.android,
        ),
    ),
)
