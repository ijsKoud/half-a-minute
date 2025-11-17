package nl.klrnbk.daan.half_a_minute.data.net.error

data class UnAuthorizedError(
    override val message: String?,
) : Exception(message)
