package com.example.mvvm.use_case

import com.example.mvvm.repository.UserRepository
import io.reactivex.Completable

interface DeleteAllUsersUseCase {
    fun deleteAllUsers(): Completable
}

class DeleteAllUsersUseCaseImpl(private val userRepository: UserRepository):
        DeleteAllUsersUseCase{
    override fun deleteAllUsers(): Completable {
        return userRepository.deleteAllUsers()
    }
}