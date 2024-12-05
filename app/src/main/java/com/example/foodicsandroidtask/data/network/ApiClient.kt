package com.example.foodicsandroidtask.data.network

import com.example.foodicsandroidtask.model.Category
import com.example.foodicsandroidtask.model.Product
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiClient (
    private val httpClient: HttpClient
) {

    suspend fun getCategories(): List<Category> {
        return httpClient.get("$BaseUrl/categories").body()
    }

    suspend fun getProductsByCategory(categoryId: String): List<Product> {
        return httpClient.get("$BaseUrl/products") {
            parameter("categoryId", categoryId)
        }.body()
    }

    companion object {
        // Project's Mock api base url which is hosted on https://beeceptor.com/
        private const val BaseUrl = "https://mp8cd6b904501e1c7f15.free.beeceptor.com"
    }
}
