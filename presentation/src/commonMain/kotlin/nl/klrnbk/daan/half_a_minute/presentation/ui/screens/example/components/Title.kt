package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.example.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import kmp_template.presentation.generated.resources.Res
import kmp_template.presentation.generated.resources.example_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun Title() {
    Text(
        style = AppTheme.typography.h1,
        text = stringResource(Res.string.example_title),
        color = AppTheme.colors.text,
    )
}
