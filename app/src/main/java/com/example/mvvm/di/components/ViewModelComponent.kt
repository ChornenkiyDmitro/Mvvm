package com.example.mvvm.di.components

import com.example.mvvm.di.modules.ViewModelModule
import com.example.mvvm.di.scopes.ViewModelScope
import com.example.mvvm.presentation.detail.DetailActivity
import com.example.mvvm.presentation.list.ListActivity
import com.example.mvvm.presentation.main.MainActivity
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [UseCasesComponent::class])
interface ViewModelComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: ListActivity)
    fun inject(activity: DetailActivity)
}