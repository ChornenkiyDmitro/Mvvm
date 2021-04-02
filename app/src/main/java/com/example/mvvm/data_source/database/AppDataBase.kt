package com.example.mvvm.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm.data_source.database.dao.UserDao
import com.example.mvvm.data_source.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}