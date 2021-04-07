package com.example.mvvm.data_source

import com.example.mvvm.data_source.database.AppDataBase
import com.example.mvvm.data_source.database.dao.UserDao
import com.example.mvvm.data_source.database.entity.UserEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface DataSource {

    fun getAllUsers(): Flowable<List<UserEntity>>
    fun getUserById(id: Int): Flowable<UserEntity>
    fun deleteUserById(id: Int): Completable
    fun deleteAllUsers(): Completable
    fun insertUser(user: UserEntity): Completable
    fun updateUser(user: UserEntity): Completable
}

class DataSourceImpl(private val dataBase: AppDataBase) : DataSource {
    override fun getAllUsers(): Flowable<List<UserEntity>> {
        return Flowable.just(dataBase.getUserDao().getAllUsers())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun getUserById(id: Int): Flowable<UserEntity> {
        return Flowable.just(dataBase.getUserDao().getUsersById(id))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun deleteUserById(id: Int): Completable {
        return Completable.fromAction {
            dataBase.getUserDao().deleteUsersById(id)
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun deleteAllUsers(): Completable {
        return Completable.fromAction {
            dataBase.getUserDao().deleteAllUsers()
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun insertUser(user: UserEntity): Completable {
        return Completable.fromAction {
            dataBase.getUserDao().insertUser(user)
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun updateUser(user: UserEntity): Completable {
        return Completable.fromAction {
            dataBase.getUserDao().updateUser(user)
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}