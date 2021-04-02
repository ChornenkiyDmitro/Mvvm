package com.example.mvvm.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.R
import com.example.mvvm.data_source.database.entity.UserEntity
import com.example.mvvm.di.components.ViewModelComponent
import com.example.mvvm.presentation.base.BaseActivity
import com.example.mvvm.presentation.list.ListActivity
import com.example.mvvm.view_model.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    var mainViewModel: MainViewModel? = null @Inject set

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSave.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val name = etName.text.toString()
        val surname = etSurname.text.toString()
        val gender = etGender.text.toString()
        val age = etAge.text

        if (inputCheck(name, surname, gender, age)) {
            val userInsert = UserEntity(0, name, surname, gender, Integer.parseInt(age.toString()))
            mainViewModel?.insertUser(userInsert)
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()

            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
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