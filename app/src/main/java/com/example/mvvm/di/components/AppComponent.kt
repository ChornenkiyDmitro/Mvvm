package com.example.mvvm.di.components

import com.example.mvvm.di.modules.AppModule
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {}