package com.example.mvvm.di.components

import com.example.mvvm.di.scopes.RemoteDataSourceScope
import com.example.mvvm.di.modules.RemoteDataSourceModule
import com.example.mvvm.remote_data_source.RemoteDataSource
import dagger.Component

@RemoteDataSourceScope
@Component(modules = [RemoteDataSourceModule::class], dependencies = [AppComponent::class])
interface RemoteDataSourceComponent {
    val remoteDataSource : RemoteDataSource
}