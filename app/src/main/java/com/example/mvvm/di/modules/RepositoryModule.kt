package com.example.mvvm.di.modules

import com.example.mvvm.data_source.DataSource
import com.example.mvvm.di.scopes.RepositoryScope
import com.example.mvvm.remote_data_source.RemoteDataSource
import com.example.mvvm.repository.UserRepository
import com.example.mvvm.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @RepositoryScope
    @Provides
    internal fun providesUserRepository(remoteDataSource: RemoteDataSource, dataSource: DataSource): UserRepository {
        return UserRepositoryImpl(dataSource, remoteDataSource)
    }
}