package com.example.foodicsandroidtask.di

import com.example.foodicsandroidtask.data.Repository
import com.example.foodicsandroidtask.ui.presenter.TablesViewmodel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::Repository)

    viewModelOf(::TablesViewmodel)
}
