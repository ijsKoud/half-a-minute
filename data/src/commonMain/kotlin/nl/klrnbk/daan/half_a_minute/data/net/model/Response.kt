package nl.klrnbk.daan.half_a_minute.data.net.model

import io.ktor.client.statement.HttpResponse

data class Response<T>(
    val response: HttpResponse,
)
