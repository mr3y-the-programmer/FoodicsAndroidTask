package com.example.foodicsandroidtask.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.foodicsandroidtask.model.Category
import com.example.foodicsandroidtask.model.Product
import com.example.foodicsandroidtask.model.SampleCategories
import com.example.foodicsandroidtask.model.SampleProducts
import com.example.foodicsandroidtask.ui.presenter.TablesUiState
import com.example.foodicsandroidtask.ui.presenter.TablesViewmodel
import com.example.foodicsandroidtask.ui.theme.FoodicsAndroidTaskTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun TablesScreen(
    modifier: Modifier = Modifier,
    viewModel: TablesViewmodel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    TablesScreen(
        state = state,
        onSearchTextChange = viewModel::updateSearchQuery,
        onSelectedCategoryChange = viewModel::selectCategory,
        onProductClick = viewModel::addProductToOrder,
        onViewOrderClick = viewModel::clearOrder,
        modifier = modifier
    )
}

@Composable
fun TablesScreen(
    state: TablesUiState,
    onSearchTextChange: (String) -> Unit,
    onSelectedCategoryChange: (categoryIndex: Int) -> Unit,
    onProductClick: (Product) -> Unit,
    onViewOrderClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets.exclude(NavigationBarDefaults.windowInsets),
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            SearchProducts(
                searchText = state.searchQuery,
                onSearchTextChange = onSearchTextChange,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .padding(bottom = 8.dp)
                    .widthIn(max = 464.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
            CategoriesTabRow(
                allCategories = state.allCategories,
                selectedCategoryIndex = state.selectedCategoryIndex,
                onSelectedCategoryIndexChange = onSelectedCategoryChange,
                modifier = Modifier
                    .widthIn(max = 464.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
            ProductsList(
                products = state.allProducts,
                onProductClick = onProductClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            OrderView(
                orderProducts = state.orderProducts,
                onClick = onViewOrderClick,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .widthIn(max = 464.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .height(48.dp)
            )
        }
    }
}

@Composable
private fun SearchProducts(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = searchText,
        onValueChange = onSearchTextChange,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                tint = MaterialTheme.colorScheme.onSurface,
                contentDescription = "Search"
            )
        },
        placeholder = { Text(text = "Search for products") },
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CategoriesTabRow(
    allCategories: List<Category>,
    selectedCategoryIndex: Int,
    onSelectedCategoryIndexChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    if (allCategories.isEmpty()) {
        Box(
            modifier = modifier.padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        SecondaryScrollableTabRow(
            selectedTabIndex = selectedCategoryIndex,
            divider = {},
            edgePadding = 16.dp,
            modifier = modifier
        ) {
            allCategories.forEachIndexed { index, category ->
                Tab(
                    selected = index == selectedCategoryIndex,
                    onClick = { onSelectedCategoryIndexChange(index) },
                    selectedContentColor = MaterialTheme.colorScheme.onSurface,
                    unselectedContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Text(
                        text = category.name,
                        fontWeight = if (index == selectedCategoryIndex) FontWeight.Bold else null
                    )
                }
            }
        }
    }
}

@Composable
private fun ProductsList(
    products: List<Product>?,
    onProductClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    when {
        products == null -> {
            Box(
                modifier = modifier.background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        products.isEmpty() -> {
            Box(
                modifier = modifier.background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No products found, Refine your search & try again",
                    textAlign = TextAlign.Center
                )
            }
        }
        else -> {
            Box(
                modifier = modifier
                    .graphicsLayer {
                        compositingStrategy = CompositingStrategy.Offscreen
                    }
                    .drawWithContent {
                        drawContent()
                        drawRect(
                            brush = Brush.verticalGradient(
                                0.1f to Color.Black,
                                0.3f to Color.Black,
                                0.6f to Color.Black,
                                0.8f to Color.Black,
                                0.999f to Color.Transparent
                            ),
                            blendMode = BlendMode.DstIn
                        )
                    }
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(128.dp),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.background(MaterialTheme.colorScheme.background)
                ) {
                    items(products, key = { it.id }) {
                        Product(
                            product = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .clickable(
                                    onClick = { onProductClick(it) }
                                )
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun Product(
    product: Product,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface, contentColor = MaterialTheme.colorScheme.onSurface),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        modifier = modifier
    ) {
        AsyncImage(
            model = product.image,
            contentDescription = null,
            placeholder = ColorPainter(MaterialTheme.colorScheme.onSurfaceVariant),
            error = ColorPainter(MaterialTheme.colorScheme.onSurfaceVariant),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(96.dp)
        )
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = product.name
            )
            if (product.description != null) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = "\n",
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = product.description,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Text(
                text = "SAR ${product.price}",
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Composable
private fun OrderView(
    orderProducts: List<Product>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val prodsWithQuantity = remember(orderProducts) { orderProducts.groupBy { it.name }.mapValues { it.value.size }.toList() }
    val totalPrice = remember(orderProducts) { orderProducts.sumOf { it.price } }
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = "View order"
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .weight(1f),
                ) {
                    items(prodsWithQuantity, key = { (name, _) -> name }) { (name, quantity) ->
                        Text("${quantity}x $name", color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f))
                    }
                }
                if (totalPrice != 0.0 && orderProducts.isNotEmpty()) {
                    Text(text = "SAR $totalPrice")
                }
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Next",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview(device = "spec:id=reference_phone,shape=Normal,width=411,height=891,unit=dp,dpi=420")
@Preview(device = "spec:id=reference_foldable,shape=Normal,width=673,height=841,unit=dp,dpi=420")
@Composable
fun TablesScreenPreview() {
    FoodicsAndroidTaskTheme {
        TablesScreen(
            state = TablesUiState(
                allCategories = SampleCategories,
                selectedCategoryIndex = 0,
                searchQuery = "",
                allProducts = SampleProducts,
                orderProducts = listOf(SampleProducts[0], SampleProducts[0], SampleProducts[2])
            ),
            onSearchTextChange = {},
            onSelectedCategoryChange = {},
            onProductClick = {},
            onViewOrderClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}
