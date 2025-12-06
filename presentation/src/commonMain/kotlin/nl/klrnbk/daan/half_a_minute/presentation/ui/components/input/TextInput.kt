package nl.klrnbk.daan.half_a_minute.presentation.ui.components.input

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import kotlin.Int.Companion
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition.InteractionStyle
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension

@Composable
fun TextInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    errorMessage: String? = null,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource? = null,
    style: InteractionStyle = AppTheme.colors.input.default
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        prefix = prefix,
        suffix = suffix,
        supportingText = {
            if (errorMessage != null) {
                val color = if (enabled) {
                    AppTheme.colors.input.danger.background.base
                } else {
                    AppTheme.colors.input.danger.background.muted
                }

                Text(
                    text = errorMessage,
                    color = color,
                    style = AppTheme.typography.inputSupportMessage,
                    modifier = Modifier.padding(vertical = Dimension.Padding.small)
                )
            }
        },
        isError = errorMessage != null,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        interactionSource = interactionSource,
        shape = RoundedCornerShape(Dimension.Input.borderRadius),
        colors = TextFieldDefaults.colors(
            disabledTextColor = style.text.muted,
            disabledContainerColor = style.background.muted,
            disabledPrefixColor = style.text.muted,
            disabledLabelColor = style.text.muted,
            disabledSuffixColor = style.text.muted,
            disabledPlaceholderColor = style.text.muted,
            disabledLeadingIconColor = style.text.muted,
            disabledTrailingIconColor = style.text.muted,
            errorTextColor = AppTheme.colors.input.danger.text.base,
            errorSupportingTextColor = AppTheme.colors.input.danger.background.base,
            errorContainerColor = AppTheme.colors.input.danger.background.base,
            errorLabelColor = AppTheme.colors.input.danger.background.base,
            errorCursorColor = AppTheme.colors.input.danger.text.base,
            errorPrefixColor = AppTheme.colors.input.danger.text.base,
            errorSuffixColor = AppTheme.colors.input.danger.text.base,
            errorIndicatorColor = Color.Transparent,
            errorPlaceholderColor = AppTheme.colors.input.danger.text.base,
            errorLeadingIconColor = AppTheme.colors.input.danger.text.base,
            errorTrailingIconColor = AppTheme.colors.input.danger.text.base,
            focusedContainerColor = style.background.base,
            unfocusedContainerColor = style.background.base,
            focusedTextColor = style.text.base,
            unfocusedTextColor = style.text.base,
            focusedLabelColor = style.text.base,
            unfocusedLabelColor = style.text.base,
            focusedPrefixColor = style.text.base,
            unfocusedPrefixColor = style.text.base,
            focusedSuffixColor = style.text.base,
            unfocusedSuffixColor = style.text.base,
            focusedTrailingIconColor = style.text.base,
            unfocusedTrailingIconColor = style.text.base,
            focusedLeadingIconColor = style.text.base,
            unfocusedLeadingIconColor = style.text.base,
            focusedPlaceholderColor = style.text.muted,
            unfocusedPlaceholderColor = style.text.muted,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}
