package com.example.mvvm.presentation.detail

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mvvm.R
import com.example.mvvm.data_source.database.entity.UserEntity
import com.example.mvvm.di.components.ViewModelComponent
import com.example.mvvm.presentation.base.BaseActivity
import com.example.mvvm.presentation.list.ListActivity
import com.example.mvvm.view_model.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail_user.*
import kotlinx.android.synthetic.main.activity_main.etAge
import kotlinx.android.synthetic.main.activity_main.etGender
import kotlinx.android.synthetic.main.activity_main.etName
import kotlinx.android.synthetic.main.activity_main.etSurname
import javax.inject.Inject

class DetailActivity: BaseActivity() {

    var detailViewModel : DetailViewModel? = null @Inject set

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)
        setupViewModel()

        val idUser = intent.getIntExtra("user", -1)
        if (idUser != -1) {
            detailViewModel?.getUsersById(idUser)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        detailViewModel?.userGetById?.removeObservers(this)
    }

    private fun setupViewModel() {
        detailViewModel?.userGetById?.observe(this, Observer { user ->
            user?.let {
                title = it.name
                buttonUpdate.setOnClickListener {
                    updateUser(user.id)
                }
            }
        })
    }

    private fun updateUser(id: Int) {
        val name = etName.text.toString()
        val surname = etSurname.text.toString()
        val gender = etGender.text.toString()
        val age = etAge.text

        if (inputCheck(name, surname, gender, age)) {
            val userUpdate = UserEntity(id, name, surname, gender, Integer.parseInt(age.toString()))
            detailViewModel?.updateUser(userUpdate)
            Toast.makeText(this, "Success change", Toast.LENGTH_LONG).show()

            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            finish()

        } else {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String, surname: String, gender: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(name)
                && TextUtils.isEmpty(surname)
                && TextUtils.isEmpty(gender)
                && age.isEmpty())

    }

}