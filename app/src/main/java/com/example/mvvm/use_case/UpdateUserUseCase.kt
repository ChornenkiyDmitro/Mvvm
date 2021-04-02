package com.example.mvvm.use_case

import com.example.mvvm.data_source.database.entity.UserEntity
import com.example.mvvm.repository.UserRepository
import io.reactivex.Completable

interface UpdateUserUseCase {
    fun updateUser(user: UserEntity): Completable
}
class UpdateUserUseCaseImpl(private val userRepository: UserRepository) : UpdateUserUseCase{
    override fun updateUser(user: UserEntity): Completable {
       return userRepository.updateUser(user)
    }

}