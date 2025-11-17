package nl.klrnbk.daan.half_a_minute.data.net.error

class NetworkError(
    responseMessage: String,
    responseCode: Int,
) : Exception(
    "Network error: $responseMessage ($responseCode)",
)
