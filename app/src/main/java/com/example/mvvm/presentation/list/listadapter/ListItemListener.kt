package com.example.mvvm.presentation.list.listadapter

import com.example.mvvm.data_source.database.entity.UserEntity

interface ListItemListener {
    fun onUserClick(user: UserEntity)
    fun onUserLongClick(user: UserEntity)
}