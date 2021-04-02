package com.example.mvvm

import android.app.Application
import androidx.room.Room
import com.example.mvvm.data_source.database.AppDataBase
import com.example.mvvm.di.components.*
import com.example.mvvm.di.modules.*

class MVVMApplication : Application() {

    private var database: AppDataBase? = null
    private var viewModelComponent: ViewModelComponent? = null

    override fun onCreate() {
        super.onCreate()
        initDataBase()
        initDagger()
    }

    private fun initDataBase(){
        database = Room.databaseBuilder(this, AppDataBase::class.java, "user_database")
            .allowMainThreadQueries()
            .build()
    }

    private fun initDagger() {
        this?.database?.let{
            val appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

            val remoteDataSourceComponent = DaggerRemoteDataSourceComponent.builder()
                .appComponent(appComponent)
                .remoteDataSourceModule(RemoteDataSourceModule())
                .build()

            val dataSourceComponent = DaggerDataSourceComponent.builder()
                .dataSourceModule(DataSourceModule(it))
                .build()

            val repositoryComponent = DaggerRepositoryComponent.builder()
                .remoteDataSourceComponent(remoteDataSourceComponent)
                .dataSourceComponent(dataSourceComponent)
                .repositoryModule(RepositoryModule())
                .build()

            val useCasesComponent = DaggerUseCasesComponent.builder()
                .repositoryComponent(repositoryComponent)
                .useCasesModule(UseCasesModule())
                .build()

            viewModelComponent = DaggerViewModelComponent.builder()
                .useCasesComponent(useCasesComponent)
                .viewModelModule(ViewModelModule())
                .build()
        }
    }

    fun getViewModelComponent(): ViewModelComponent? {
        return this.viewModelComponent
    }
}