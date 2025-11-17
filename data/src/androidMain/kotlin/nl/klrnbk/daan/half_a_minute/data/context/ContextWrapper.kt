package nl.klrnbk.daan.half_a_minute.data.context

import android.content.Context

actual class ContextWrapper(private val context: Context) {
    fun get() = context
}
