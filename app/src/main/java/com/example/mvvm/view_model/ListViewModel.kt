package com.example.mvvm.view_model

import androidx.lifecycle.MutableLiveData
import com.example.mvvm.data_source.database.entity.UserEntity
import com.example.mvvm.use_case.*
import io.reactivex.rxkotlin.plusAssign

class ListViewModel(
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val deleteAllUsersUseCase: DeleteAllUsersUseCase,
    private val deleteUserByIdUseCase: DeleteUserByIdUseCase
) : BaseViewModel() {

    val liveDataItems = MutableLiveData<List<UserEntity>>()

    fun getAllUsers(){
        compositeDisposable += getAllUsersUseCase.getAllUsers()
            .subscribe { list ->
                liveDataItems.value = list
            }
    }

    fun deleteAllUsers(){
        compositeDisposable += deleteAllUsersUseCase.deleteAllUsers()
                .subscribe()
    }

    fun deleteUserById(id : Int){
        compositeDisposable += deleteUserByIdUseCase.deleteUserById(id = id)
                .subscribe()
    }
}