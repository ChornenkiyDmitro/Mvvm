package com.example.mvvm.di.modules

import com.example.mvvm.data_source.DataSource
import com.example.mvvm.data_source.DataSourceImpl
import com.example.mvvm.data_source.database.AppDataBase
import dagger.Module
import dagger.Provides

@Module
class DataSourceModule(private val appDatabase: AppDataBase) {

    @Provides
    internal fun providesAppDatabase(): AppDataBase {
        return appDatabase
    }

    @Provides
    internal fun providesDataSource(appDatabase: AppDataBase): DataSource {
        return DataSourceImpl(appDatabase)
    }
}