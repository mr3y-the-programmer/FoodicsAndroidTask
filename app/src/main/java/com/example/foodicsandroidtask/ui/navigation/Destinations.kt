package com.example.foodicsandroidtask.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Destinations {

    @Serializable
    data object Tables : Destinations

    @Serializable
    data object Orders : Destinations

    @Serializable
    data object Menu : Destinations

    @Serializable
    data object Settings : Destinations
}
