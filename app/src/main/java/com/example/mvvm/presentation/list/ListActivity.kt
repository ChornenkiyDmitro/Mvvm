package com.example.mvvm.presentation.list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.presentation.list.listadapter.ListAdapter
import com.example.mvvm.presentation.list.listadapter.ListItemListener
import com.example.mvvm.R
import com.example.mvvm.data_source.database.entity.UserEntity
import com.example.mvvm.di.components.ViewModelComponent
import com.example.mvvm.presentation.base.BaseActivity
import com.example.mvvm.presentation.detail.DetailActivity
import com.example.mvvm.presentation.main.MainActivity
import com.example.mvvm.view_model.ListViewModel
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

class ListActivity : BaseActivity(), ListItemListener {

    val adapter = ListAdapter(this)

    var listViewModel : ListViewModel? = null @Inject set

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        userRecyclerView.adapter = adapter
        userRecyclerView.layoutManager = LinearLayoutManager(this)

        listViewModel?.getAllUsers()
        listViewModel?.liveDataItems?.observe(this, Observer<List<UserEntity>> {
            adapter.setData(it)
        })
    }

    override fun onUserClick(user: UserEntity) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("user", user.id)
        startActivity(intent)
    }

    override fun onUserLongClick(user: UserEntity) {
        AlertDialog.Builder(this)
            .setTitle(R.string.dialog_title_delete_user_by_id)
            .setMessage(R.string.dialog_message_delete_user_by_id)
            .setPositiveButton(R.string.dialog_positive_button) { dialog, _ ->
                deleteUserById(user.id)
                dialog.dismiss()
            }
            .setNegativeButton(R.string.dialog_negative_button) { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun deleteUserById(id: Int) {
        listViewModel?.deleteUserById(id)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(R.string.menu_delete_all_users)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        AlertDialog.Builder(this)
            .setTitle(R.string.dialog_title_delete_all_users)
            .setMessage(R.string.dialog_message_delete_all_users)
            .setPositiveButton(R.string.dialog_positive_button) { dialog, _ ->
                deleteAllUsers()
                dialog.dismiss()
                startMainActivity()
            }
            .setNegativeButton(R.string.dialog_negative_button) { dialog, _ -> dialog.dismiss() }
            .show()
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllUsers() = listViewModel?.deleteAllUsers()

    private fun startMainActivity(){
        var intent = Intent(this, MainActivity::class.java)
        finishAffinity()
        startActivity(intent)
    }
}






