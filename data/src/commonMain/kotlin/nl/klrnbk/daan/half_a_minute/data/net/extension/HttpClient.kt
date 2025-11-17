package nl.klrnbk.daan.half_a_minute.data.net.extension

import nl.klrnbk.daan.half_a_minute.data.net.model.Response
import io.ktor.client.HttpClient
import io.ktor.client.plugins.resources.delete
import io.ktor.client.plugins.resources.get
import io.ktor.client.plugins.resources.head
import io.ktor.client.plugins.resources.options
import io.ktor.client.plugins.resources.patch
import io.ktor.client.plugins.resources.post
import io.ktor.client.plugins.resources.put
import io.ktor.client.request.HttpRequestBuilder

suspend inline fun <T, reified R : Any> HttpClient.get(
    resource: R,
    builder: HttpRequestBuilder.() -> Unit = {},
): Response<T> {
    return Response(this.get(resource, builder))
}

suspend inline fun <T, reified R : Any> HttpClient.post(
    resource: R,
    builder: HttpRequestBuilder.() -> Unit = {},
): Response<T> {
    return Response(this.post(resource, builder))
}

suspend inline fun <T, reified R : Any> HttpClient.put(
    resource: R,
    builder: HttpRequestBuilder.() -> Unit = {},
): Response<T> {
    return Response(this.put(resource, builder))
}

suspend inline fun <T, reified R : Any> HttpClient.delete(
    resource: R,
    builder: HttpRequestBuilder.() -> Unit = {},
): Response<T> {
    return Response(this.delete(resource, builder))
}

suspend inline fun <T, reified R : Any> HttpClient.patch(
    resource: R,
    builder: HttpRequestBuilder.() -> Unit = {},
): Response<T> {
    return Response(this.patch(resource, builder))
}

suspend inline fun <T, reified R : Any> HttpClient.head(
    resource: R,
    builder: HttpRequestBuilder.() -> Unit = {},
): Response<T> {
    return Response(this.head(resource, builder))
}

suspend inline fun <T, reified R : Any> HttpClient.options(
    resource: R,
    builder: HttpRequestBuilder.() -> Unit = {},
): Response<T> {
    return Response(this.options(resource, builder))
}
