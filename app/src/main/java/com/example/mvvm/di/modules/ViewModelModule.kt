package com.example.mvvm.di.modules

import com.example.mvvm.di.scopes.ViewModelScope
import com.example.mvvm.use_case.*
import com.example.mvvm.view_model.DetailViewModel
import com.example.mvvm.view_model.ListViewModel
import com.example.mvvm.view_model.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @ViewModelScope
    @Provides
    internal fun providesMainViewModel(
        insertUserUseCase: InsertUserUseCase
    ): MainViewModel {
        return MainViewModel(insertUserUseCase)
    }

    @ViewModelScope
    @Provides
    internal fun providesListViewModel(
        getAllUsersUseCase: GetAllUsersUseCase,
        deleteAllUsersUseCase: DeleteAllUsersUseCase,
        deleteUserByIdUseCase: DeleteUserByIdUseCase
    ): ListViewModel {
        return ListViewModel(
            getAllUsersUseCase,
            deleteAllUsersUseCase,
            deleteUserByIdUseCase
        )
    }

    @ViewModelScope
    @Provides
    internal fun providesDetailViewModel(
        updateUserUseCase: UpdateUserUseCase,
        getUserByIdUseCase: GetUserByIdUseCase
    ): DetailViewModel {
        return DetailViewModel(
            updateUserUseCase,
            getUserByIdUseCase
        )
    }
}