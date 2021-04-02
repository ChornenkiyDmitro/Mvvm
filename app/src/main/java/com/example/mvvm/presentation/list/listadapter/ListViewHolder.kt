package com.example.mvvm.presentation.list.listadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.data_source.database.entity.UserEntity
import com.example.mvvm.presentation.list.listadapter.ListItemListener
import kotlinx.android.synthetic.main.list_item.view.*

open class ListViewHolder(
    itemView: View,
    private val listItemListener: ListItemListener
) : RecyclerView.ViewHolder(itemView) {

    fun bind(user: UserEntity) {
        with(itemView) {
            tvUserId.text = user.id.toString()
            tvUserName.text = user.name
            tvUserSurname.text = user.surname
            tvUserGender.text = user.gender
            tvUserAge.text = user.age.toString()

            setOnClickListener {
                listItemListener.onUserClick(user)
            }
            setOnLongClickListener {
                listItemListener.onUserLongClick(user)
                return@setOnLongClickListener true
            }
        }
    }
}