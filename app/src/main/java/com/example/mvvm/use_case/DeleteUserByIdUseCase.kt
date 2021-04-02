package com.example.mvvm.use_case

import com.example.mvvm.repository.UserRepository
import io.reactivex.Completable

interface DeleteUserByIdUseCase{
    fun deleteUserById(id: Int): Completable
}

class DeleteUserByIdUseCaseImpl(private val userRepository: UserRepository):
    DeleteUserByIdUseCase{
    override fun deleteUserById(id: Int): Completable {
        return userRepository.deleteUserById(id)
    }
}