package com.example.mvvm.di.components

import com.example.mvvm.di.modules.RepositoryModule
import com.example.mvvm.di.scopes.RepositoryScope
import com.example.mvvm.repository.UserRepository
import dagger.Component

@RepositoryScope
@Component(modules = [RepositoryModule::class], dependencies = [RemoteDataSourceComponent::class, DataSourceComponent::class])
interface RepositoryComponent {
    val userRepository: UserRepository
}