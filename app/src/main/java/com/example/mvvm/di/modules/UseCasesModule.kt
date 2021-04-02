package com.example.mvvm.di.modules

import com.example.mvvm.di.scopes.UseCasesScope
import com.example.mvvm.repository.UserRepository
import com.example.mvvm.use_case.*
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @UseCasesScope
    @Provides
    internal fun providesGetAllUsersUseCase(userRepository: UserRepository): GetAllUsersUseCase {
        return GetAllUsersUseCaseImpl(userRepository)
    }

    @UseCasesScope
    @Provides
    internal fun providesGetUserByIdUseCase(userRepository: UserRepository): GetUserByIdUseCase {
        return GetUserByIdUseCaseImpl(userRepository)
    }

    @UseCasesScope
    @Provides
    internal fun providesDeleteAllUsersUseCase(userRepository: UserRepository): DeleteAllUsersUseCase {
        return DeleteAllUsersUseCaseImpl(userRepository)
    }

    @UseCasesScope
    @Provides
    internal fun providesDeleteUserByIdUseCase(userRepository: UserRepository): DeleteUserByIdUseCase {
        return DeleteUserByIdUseCaseImpl(userRepository)
    }

    @UseCasesScope
    @Provides
    internal fun providesInsertUserUseCase(userRepository: UserRepository): InsertUserUseCase {
        return InsertUserUseCaseImpl(userRepository)
    }

    @UseCasesScope
    @Provides
    internal fun providesUpdateUserUseCase(userRepository: UserRepository): UpdateUserUseCase {
        return UpdateUserUseCaseImpl(userRepository)
    }
}