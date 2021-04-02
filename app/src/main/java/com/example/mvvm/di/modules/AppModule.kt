package com.example.mvvm.di.modules

import android.app.Application
import com.example.mvvm.di.scopes.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app : Application) {

    @Provides
    @AppScope
    fun provideApplication(): Application {
        return app
    }
}