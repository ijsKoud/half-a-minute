package nl.klrnbk.daan.half_a_minute.presentation.ui.factory

import nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog.DialogAction
import platform.UIKit.UIViewController

interface NativeViewFactory {
    fun dialogFactory(
        title: String,
        description: String?,
        actions: List<DialogAction>
    ): UIViewController
}
