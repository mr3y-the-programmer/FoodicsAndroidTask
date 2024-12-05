package com.example.foodicsandroidtask.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondBadRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object FakeHttpClient {

    private val jsonInstance = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    fun getInstance(): HttpClient {
        val engine = MockEngine.create {
            requestHandlers.add { request ->
                if (request.url.encodedPath.startsWith("/products")) {
                    respond(
                        content = SampleProductsJsonResponse,
                        status = HttpStatusCode.OK,
                        headers = headers {
                            append(HttpHeaders.ContentType, "application/json")
                        },
                    )
                } else if (request.url.encodedPath.startsWith("/categories")) {
                    respond(
                        content = SampleCategoriesJsonResponse,
                        status = HttpStatusCode.OK,
                        headers = headers {
                            append(HttpHeaders.ContentType, "application/json")
                        },
                    )
                } else {
                    respondBadRequest()
                }
            }
        }

        return HttpClient(engine) {
            install(ContentNegotiation) {
                json(jsonInstance)
            }
        }
    }
}
