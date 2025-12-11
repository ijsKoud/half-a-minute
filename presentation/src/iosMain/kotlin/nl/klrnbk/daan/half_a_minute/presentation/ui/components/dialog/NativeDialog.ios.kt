package nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog

import LocalNativeViewFactory
import androidx.compose.runtime.Composable
import com.infiniteretry.snizzors.SnizzorsUIViewController

@Composable
actual fun NativeDialog(title: String, description: String?, actions: List<DialogAction>) {
    val factories = LocalNativeViewFactory.current

    SnizzorsUIViewController(
        update = {},
        factory = {
            factories.dialogFactory(title, description, actions)
        }
    )
}
