package nl.klrnbk.daan.half_a_minute.presentation.ui.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition.InteractionStyle
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension

@Composable
fun StyledButton(
    modifier: Modifier = Modifier,
    disabled: Boolean = false,
    onClick: () -> Unit,
    style: InteractionStyle = AppTheme.colors.button.primary,
    content: @Composable (RowScope.() -> Unit)
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = !disabled,
        shape = RoundedCornerShape(Dimension.Button.borderRadius),
        contentPadding = PaddingValues(
            horizontal = Dimension.Button.horizontalPadding,
            vertical = Dimension.Button.verticalPadding
        ),
        colors = ButtonColors(
            containerColor = style.background.base,
            disabledContainerColor = style.background.muted,
            contentColor = style.text.base,
            disabledContentColor = style.text.muted,
        ),
        content = content
    )
}