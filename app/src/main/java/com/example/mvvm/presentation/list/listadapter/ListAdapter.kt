package com.example.mvvm.presentation.list.listadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.data_source.database.entity.UserEntity
import com.example.mvvm.presentation.list.listadapter.ListItemListener
import com.example.mvvm.presentation.list.listadapter.ListViewHolder


class ListAdapter(private val listener: ListItemListener) : RecyclerView.Adapter<ListViewHolder>() {

    private var userList = mutableListOf<UserEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false),
            listener
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    fun setData(user: List<UserEntity>) {
        Log.d("ListAdapter", "users = $user")
        userList.clear()
        userList.addAll(user)
        notifyDataSetChanged()
    }

}