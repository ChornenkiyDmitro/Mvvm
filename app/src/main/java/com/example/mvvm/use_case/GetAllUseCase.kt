package com.example.mvvm.use_case

import com.example.mvvm.data_source.database.entity.UserEntity
import com.example.mvvm.repository.UserRepository
import io.reactivex.Flowable

interface GetAllUsersUseCase {
    fun getAllUsers(): Flowable<List<UserEntity>>
}

class GetAllUsersUseCaseImpl(private val userRepository: UserRepository) : GetAllUsersUseCase {
    override fun getAllUsers(): Flowable<List<UserEntity>> {
        return userRepository.getAllUsers()
    }
}