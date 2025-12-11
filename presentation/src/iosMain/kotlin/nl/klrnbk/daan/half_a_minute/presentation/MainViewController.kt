import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.window.ComposeUIViewController
import nl.klrnbk.daan.half_a_minute.data.context.ContextWrapper
import nl.klrnbk.daan.half_a_minute.presentation.ui.App
import nl.klrnbk.daan.half_a_minute.presentation.ui.factory.NativeViewFactory

val LocalNativeViewFactory = staticCompositionLocalOf<NativeViewFactory> {
    error("No view factories initialized")
}

fun MainViewController(viewFactory: NativeViewFactory) = ComposeUIViewController {
    CompositionLocalProvider(LocalNativeViewFactory provides viewFactory) {
        App(ContextWrapper())
    }
}
