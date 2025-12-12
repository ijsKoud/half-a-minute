package nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog

data class DialogAction(val name: String, val type: DialogActionType, val action: () -> Unit)

enum class DialogActionType {
    SUBMIT,
    DISMISS,
    DESTRUCTIVE
}
