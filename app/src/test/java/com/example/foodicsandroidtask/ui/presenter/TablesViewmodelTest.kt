package com.example.foodicsandroidtask.ui.presenter

import app.cash.turbine.test
import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEmpty
import assertk.assertions.isEqualTo
import com.example.foodicsandroidtask.data.Repository
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

    private lateinit var viewModel: TablesViewmodel

    @Test
    fun testInteractionsWithStateProduceExpectedResults() = runTest {
        viewModel = TablesViewmodel(Repository())

        viewModel.state.test {
            var currentState = awaitItem()
            assertThat(currentState).isEqualTo(
                TablesUiState.Default.copy(
                    allCategories = SampleCategories,
                    allProducts = SampleProducts
                )
            )

            viewModel.updateSearchQuery("bur") // simulate user searching for burger product
            currentState = awaitItem()

            // search query state is updated immediately while search results are still loading
            assertThat(currentState.searchQuery).isEqualTo("bur")
            assertThat(currentState.allProducts).isEqualTo(SampleProducts) // products same as before
            currentState = awaitItem()
            assertThat(currentState.allProducts).hasSize(1)
            assertThat(currentState.allProducts.first().name).isEqualTo("Burger")

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
