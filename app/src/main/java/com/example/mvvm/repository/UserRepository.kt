package com.example.mvvm.repository

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mvvm.data_source.DataSource
import com.example.mvvm.data_source.database.entity.UserEntity
import com.example.mvvm.remote_data_source.RemoteDataSource
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface UserRepository {

    fun getAllUsers(): Flowable<List<UserEntity>>
    fun getUserById(id: Int): Flowable<UserEntity>
    fun deleteUserById(id: Int): Completable
    fun deleteAllUsers(): Completable
    fun insertUser(user: UserEntity): Completable
    fun updateUser(user: UserEntity): Completable
}

class UserRepositoryImpl(
    private val dataSource: DataSource,
    private val remoteDataSource: RemoteDataSource
) : UserRepository {
    override fun getAllUsers(): Flowable<List<UserEntity>> {
        return dataSource.getAllUsers()
    }

    override fun getUserById(id: Int): Flowable<UserEntity> {
        return dataSource.getUserById(id)
    }

    override fun deleteUserById(id: Int): Completable {
        return deleteUserById(id)
    }

    override fun deleteAllUsers(): Completable {
        return dataSource.deleteAllUsers()
    }

    override fun insertUser(user: UserEntity): Completable {
        return dataSource.insertUser(user)
    }

    override fun updateUser(user: UserEntity): Completable {
        return dataSource.updateUser(user)
    }

}