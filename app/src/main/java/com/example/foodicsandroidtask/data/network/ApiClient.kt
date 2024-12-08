package com.example.foodicsandroidtask.data.network

import android.util.Log
import com.example.foodicsandroidtask.model.Category
import com.example.foodicsandroidtask.model.Product
import io.ktor.client.HttpClient
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

class ApiClient (
    private val httpClient: HttpClient
) {

    suspend fun getCategories(): List<Category>? {
        return withCatching { httpClient.get("$BaseUrl/categories") }
    }

    suspend fun getProductsByCategory(categoryId: String): List<Product>? {
        return withCatching {
            httpClient.get("$BaseUrl/products") { parameter("categoryId", categoryId) }
        }
    }

    private suspend inline fun <reified T> withCatching(block: () -> HttpResponse): T? {
        return try {
            val response = block()
            if (response.status.isSuccess()) {
                response.body()
            } else {
                Log.w("ApiClient", "Request failed! http status code: ${response.status}")
                null
            }
        } catch (ex: NoTransformationFoundException) {
            Log.w("ApiClient", "Exception occurred while deserializing response: ${ex.message}")
            null
        } catch (ex: Exception) {
            Log.e("ApiClient", "Unknown exception encountered while making api call: ${ex.message}")
            null
        }
    }

    companion object {
        // Project's Mock api base url which is hosted on https://beeceptor.com/
        private const val BaseUrl = "https://mp8cd6b904501e1c7f15.free.beeceptor.com"
    }
}
