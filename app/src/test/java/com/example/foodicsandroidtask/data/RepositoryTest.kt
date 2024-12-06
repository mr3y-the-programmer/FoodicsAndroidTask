package com.example.foodicsandroidtask.data

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import com.example.foodicsandroidtask.data.local.InMemoryDao
import com.example.foodicsandroidtask.data.local.toCategory
import com.example.foodicsandroidtask.data.local.toProduct
import com.example.foodicsandroidtask.data.network.ApiClient
import com.example.foodicsandroidtask.data.network.FakeHttpClient
import com.example.foodicsandroidtask.model.SampleCategories
import com.example.foodicsandroidtask.model.SampleProducts
import kotlinx.coroutines.test.runTest
import org.junit.Test

class RepositoryTest {

    private lateinit var repository: Repository

    @Test
    fun testRepoSyncsLocalWithRemoteDataSource() = runTest {
        val httpClient = FakeHttpClient.getInstance()
        val dao = InMemoryDao()
        repository = Repository(ApiClient(httpClient = httpClient), dao)

        repository.getAllCategories()
        assertThat(dao.getAllCategories().map { it.toCategory() }).isEqualTo(SampleCategories)

        repository.getProductsBy(SampleCategories[0].id)
        assertThat(dao.getAllProducts().map { it.toProduct() }).isEqualTo(SampleProducts)

        val searchResult = repository.getProductsBy(SampleCategories[0].id, "bur")
        assertThat(searchResult).hasSize(1)
        assertThat(searchResult.first().name).isEqualTo("Burger")
    }
}
