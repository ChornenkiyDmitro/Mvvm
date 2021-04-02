package com.example.mvvm.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import com.example.mvvm.data_source.database.entity.UserEntity
import com.example.mvvm.use_case.GetUserByIdUseCase
import com.example.mvvm.use_case.UpdateUserUseCase
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.rxkotlin.plusAssign

class DetailViewModel(
        private val updateUserUseCase: UpdateUserUseCase,
        private val getUserByIdUseCase: GetUserByIdUseCase
) : BaseViewModel() {

    val userGetById = MutableLiveData<UserEntity>()
    val actionError = MutableLiveData<String>()
    val actionUserUpdate = MutableLiveData<ActionDetailNextScreen>()

    fun getUsersById(id: Int) {
        compositeDisposable += getUserByIdUseCase.getUserById(id = id)
                .subscribe { user ->
                    userGetById.value = user
                }
    }

    fun updateUser(user: UserEntity) {
        compositeDisposable += updateUserUseCase.updateUser(user)
                .subscribe({
                    actionUserUpdate.value = ActionDetailNextScreen.LIST_ACTIVITY

                }, { error ->
                    actionUserUpdate.value = ActionDetailNextScreen.DEFAULT
                    actionError.value = error.message

                })
    }

    enum class ActionDetailNextScreen {
        DEFAULT, LIST_ACTIVITY
    }
}