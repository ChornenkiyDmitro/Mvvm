package com.example.mvvm.di.modules

import com.example.mvvm.di.scopes.RemoteDataSourceScope
import com.example.mvvm.remote_data_source.RemoteDataSource
import com.example.mvvm.remote_data_source.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class RemoteDataSourceModule {

    @Provides
    @RemoteDataSourceScope
    fun provideRemoteDataSource(): RemoteDataSource {
        return RemoteDataSourceImpl()
    }

}