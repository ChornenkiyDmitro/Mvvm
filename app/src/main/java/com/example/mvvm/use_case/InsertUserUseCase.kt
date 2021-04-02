package com.example.mvvm.use_case

import com.example.mvvm.data_source.database.entity.UserEntity
import com.example.mvvm.repository.UserRepository
import io.reactivex.Completable

interface InsertUserUseCase {
    fun insertUser(user: UserEntity): Completable
}
class InsertUserUseCaseImpl(private val userRepository: UserRepository) : InsertUserUseCase{
    override fun insertUser(user: UserEntity): Completable {
        return userRepository.insertUser(user)
    }
}