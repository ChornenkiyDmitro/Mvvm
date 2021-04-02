package com.example.mvvm.data_source.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class UserEntity(

        @PrimaryKey(autoGenerate = true)
        val id: Int = 1,

        @ColumnInfo(name = "name")
        val name: String,

        @ColumnInfo(name = "surname")
        val surname: String,

        @ColumnInfo(name = "gender")
        val gender: String,

        @ColumnInfo(name = "age")
        val age: Int
)
