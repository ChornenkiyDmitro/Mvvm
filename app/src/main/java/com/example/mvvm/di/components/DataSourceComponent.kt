package com.example.mvvm.di.components

import com.example.mvvm.data_source.DataSource
import com.example.mvvm.data_source.database.AppDataBase
import com.example.mvvm.di.modules.DataSourceModule
import dagger.Component

@Component(modules = [DataSourceModule::class])
interface DataSourceComponent {
    val database: AppDataBase
    val dataSource: DataSource
}