package nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog

import androidx.compose.runtime.Composable

@Composable
expect fun NativeDialog(title: String?, description: String?, actions: List<DialogAction>)
