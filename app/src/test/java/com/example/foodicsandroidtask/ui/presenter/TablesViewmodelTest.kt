package com.example.foodicsandroidtask.ui.presenter

import app.cash.turbine.test
import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEmpty
import assertk.assertions.isEqualTo
import com.example.foodicsandroidtask.data.Repository
import com.example.foodicsandroidtask.data.network.ApiClient
import com.example.foodicsandroidtask.data.network.FakeHttpClient
import com.example.foodicsandroidtask.model.SampleCategories
import com.example.foodicsandroidtask.model.SampleProducts
import com.example.foodicsandroidtask.utils.MainDispatcherRule
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class TablesViewmodelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule(StandardTestDispatcher())

    private val httpClient = FakeHttpClient.getInstance()
    private val repository = Repository(ApiClient(httpClient = httpClient))
    private lateinit var viewModel: TablesViewmodel

    @Test
    fun testInteractionsWithStateProduceExpectedResults() = runTest {
        viewModel = TablesViewmodel(repository)

        viewModel.state.test {
            val initialState = awaitItem()
            assertThat(initialState).isEqualTo(TablesUiState.Default)

            // after data is loaded from repository
            var currentState = awaitItem()
            assertThat(currentState).isEqualTo(
                TablesUiState.Default.copy(
                    allCategories = SampleCategories,
                    allProducts = SampleProducts
                )
            )

            viewModel.updateSearchQuery("bur") // simulate user searching for burger product
            currentState = awaitItem()

            // search query state is updated immediately while search results are still loading from repository
            assertThat(currentState.searchQuery).isEqualTo("bur")
            assertThat(currentState.allProducts).isEqualTo(SampleProducts) // products same as before

            assertThat(currentState.selectedCategoryIndex).isEqualTo(0)
            viewModel.selectCategory(categoryIndex = 1)
            currentState = awaitItem()
            assertThat(currentState.selectedCategoryIndex).isEqualTo(1)

            assertThat(currentState.orderProducts).isEmpty()
            viewModel.addProductToOrder(SampleProducts[0])
            viewModel.addProductToOrder(SampleProducts[0])
            currentState = awaitItem()
            assertThat(currentState.orderProducts).hasSize(1)
            currentState = awaitItem()
            assertThat(currentState.orderProducts).hasSize(2)

            viewModel.clearOrder()
            currentState = awaitItem()
            assertThat(currentState.orderProducts).isEmpty()
        }
    }
}
