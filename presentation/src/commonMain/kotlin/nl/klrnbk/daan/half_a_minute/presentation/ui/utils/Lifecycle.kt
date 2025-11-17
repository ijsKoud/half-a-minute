package nl.klrnbk.daan.half_a_minute.presentation.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

@Composable
fun OnLifecycleEvent(
    onCreate: (suspend () -> Unit)? = null,
    onResume: (suspend () -> Unit)? = null,
    onPause: (suspend () -> Unit)? = null,
    onDestroy: (suspend () -> Unit)? = null,
) {
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                owner.lifecycleScope.launch {
                    onCreate?.invoke()
                }
            }

            override fun onResume(owner: LifecycleOwner) {
                owner.lifecycleScope.launch {
                    onResume?.invoke()
                }
            }

            override fun onPause(owner: LifecycleOwner) {
                owner.lifecycleScope.launch {
                    onPause?.invoke()
                }
            }

            override fun onDestroy(owner: LifecycleOwner) {
                owner.lifecycleScope.launch {
                    onDestroy?.invoke()
                }
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}
