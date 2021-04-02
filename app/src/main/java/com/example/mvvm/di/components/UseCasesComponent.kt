package com.example.mvvm.di.components

import com.example.mvvm.di.modules.UseCasesModule
import com.example.mvvm.di.scopes.UseCasesScope
import com.example.mvvm.use_case.*
import dagger.Component

@UseCasesScope
@Component(modules = [UseCasesModule::class], dependencies = [RepositoryComponent::class])
interface UseCasesComponent {
    val getAllUsersUseCase: GetAllUsersUseCase
    val getUserByIdUseCase: GetUserByIdUseCase
    val deleteAllUsersUseCase: DeleteAllUsersUseCase
    val deleteUserByIdUseCase: DeleteUserByIdUseCase
    val insertUserUseCase: InsertUserUseCase
    val updateUserUseCase: UpdateUserUseCase
}