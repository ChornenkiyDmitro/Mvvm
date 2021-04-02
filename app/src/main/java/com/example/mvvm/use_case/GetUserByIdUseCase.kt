package com.example.mvvm.use_case

import com.example.mvvm.data_source.database.entity.UserEntity
import com.example.mvvm.repository.UserRepository
import io.reactivex.Flowable

interface GetUserByIdUseCase {
    fun getUserById(id: Int): Flowable<UserEntity>
}
class GetUserByIdUseCaseImpl(private val userRepository: UserRepository): GetUserByIdUseCase{
    override fun getUserById(id: Int): Flowable<UserEntity> {
       return userRepository.getUserById(id)
    }

}