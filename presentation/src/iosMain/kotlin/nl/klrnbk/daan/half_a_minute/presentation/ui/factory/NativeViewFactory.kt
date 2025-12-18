package nl.klrnbk.daan.half_a_minute.presentation.ui.factory

import nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog.DialogAction
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.select.SelectMenuColors
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.select.SelectMenuOption
import platform.UIKit.UIViewController

interface NativeViewFactory {
    fun dialogFactory(
        title: String,
        description: String?,
        actions: List<DialogAction>
    ): UIViewController

    fun <T> selectMenuFactory(
        title: String,
        colors: SelectMenuColors,
        options: List<SelectMenuOption<T>>,
        selected: SelectMenuOption<T>,
        onSelect: (SelectMenuOption<T>) -> Unit
    ): UIViewController
}
