package com.example.foodicsandroidtask.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodicsandroidtask.ui.navigation.Destinations
import com.example.foodicsandroidtask.ui.resources.Orders
import com.example.foodicsandroidtask.ui.resources.Table

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Column(
        modifier = modifier
    ) {
        FoodicsNavGraph(
            navController = navController,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        BottomNavigationBar(
            navController = navController,
            currentDestination = currentDestination,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun FoodicsNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Tables,
        modifier = modifier
    ) {
        composable<Destinations.Tables> {
            TablesScreen()
        }
        composable<Destinations.Orders> {
            PlaceholderScreen(modifier = Modifier.fillMaxSize())
        }
        composable<Destinations.Menu> {
            PlaceholderScreen(modifier = Modifier.fillMaxSize())
        }
        composable<Destinations.Settings> {
            PlaceholderScreen(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
private fun BottomNavigationBar(
    navController: NavHostController,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    val navigationBarTabs = listOf(
        NavigationBarTab(
            "Tables",
            Table,
            Destinations.Tables,
        ),
        NavigationBarTab(
            "Orders",
            Orders,
            Destinations.Orders,
        ),
        NavigationBarTab(
            "Menu",
            Icons.Filled.Menu,
            Destinations.Menu,
        ),
        NavigationBarTab(
            "Settings",
            Icons.Filled.Settings,
            Destinations.Settings,
        ),
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = modifier
    ) {
        navigationBarTabs.forEach { tab ->
            val isSelected = currentDestination?.hierarchy?.any { it.hasRoute(route = tab.destination::class) } == true
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navController.navigate(tab.destination) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                label = { Text(text = tab.label) },
                icon = { Icon(tab.icon, contentDescription = null) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onSurface,
                    selectedTextColor = MaterialTheme.colorScheme.onSurface,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = Color.Transparent
                ),
            )
        }
    }
}

data class NavigationBarTab(
    val label: String,
    val icon: ImageVector,
    val destination: Destinations,
)
