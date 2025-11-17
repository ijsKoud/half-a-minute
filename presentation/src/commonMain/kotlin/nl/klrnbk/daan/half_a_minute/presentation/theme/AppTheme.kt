package nl.klrnbk.daan.half_a_minute.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.applied.LocalColors
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.applied.appColorsDark
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.applied.appColorsLight
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition.AppColors
import nl.klrnbk.daan.half_a_minute.presentation.theme.typography.applied.AppTypographies
import nl.klrnbk.daan.half_a_minute.presentation.theme.typography.applied.LocalTypography
import nl.klrnbk.daan.half_a_minute.presentation.theme.typography.definition.AppTypography

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val colors = if (isSystemInDarkTheme()) appColorsDark else appColorsLight
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides AppTypographies(),
    ) {
        SystemAppearance(isDark = isSystemInDarkTheme())
        content()
    }
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)

object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}
