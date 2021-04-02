package com.example.mvvm.view_model

import androidx.lifecycle.MutableLiveData
import com.example.mvvm.data_source.database.entity.UserEntity
import com.example.mvvm.use_case.InsertUserUseCase
import io.reactivex.rxkotlin.plusAssign

class MainViewModel ( private val insertUserUseCase: InsertUserUseCase): BaseViewModel() {

    val actionUserInserted = MutableLiveData<ActionMainNextScreen>()
    val actionError = MutableLiveData<String>()
    fun insertUser(user: UserEntity) {
        compositeDisposable += insertUserUseCase.insertUser(user)
            .subscribe({
                actionUserInserted.value = ActionMainNextScreen.LIST_ACTIVITY

            }, { error ->
                actionUserInserted.value = ActionMainNextScreen.DEFAULT
                actionError.value = error.message

            })
    }
    enum class ActionMainNextScreen {
        DEFAULT, LIST_ACTIVITY
    }
}
