package com.example.mvvm.data_source.database.dao

import androidx.room.*
import com.example.mvvm.data_source.database.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE id LIKE :id")
    fun getUsersById(id: Int): UserEntity

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserEntity>

    @Query("DELETE FROM users WHERE id LIKE :id")
    fun deleteUsersById(id: Int)

    @Query("DELETE FROM users ")
    fun deleteAllUsers()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: UserEntity)
}