package nl.klrnbk.daan.half_a_minute.data.net.mapper

import nl.klrnbk.daan.half_a_minute.data.net.error.NetworkError
import nl.klrnbk.daan.half_a_minute.data.net.error.UnAuthorizedError
import nl.klrnbk.daan.half_a_minute.data.net.model.Response
import io.ktor.client.call.body
import org.koin.core.annotation.Factory

@Factory
class ResponseMapper {

    suspend inline fun <reified T> mapResponse(response: Response<T>): Result<T> {
        return when (response.response.status.value) {
            in 200..299 -> Result.success(response.response.body())
            401 -> Result.failure(UnAuthorizedError(message = "Unauthorized to perform call"))
            else -> Result.failure(
                NetworkError(
                    responseMessage = response.response.status.description,
                    responseCode = response.response.status.value,
                ),
            )
        }
    }
}
