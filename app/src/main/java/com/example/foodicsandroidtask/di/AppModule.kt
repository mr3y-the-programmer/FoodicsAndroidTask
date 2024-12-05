package com.example.foodicsandroidtask.di

import com.example.foodicsandroidtask.data.Repository
import com.example.foodicsandroidtask.data.network.ApiClient
import com.example.foodicsandroidtask.ui.presenter.TablesViewmodel
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single {
        ApiClient(
            httpClient = HttpClient(OkHttp) {
                install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            isLenient = true
                        }
                    )
                }
            }
        )
    }

    singleOf(::Repository)

    viewModelOf(::TablesViewmodel)
}
