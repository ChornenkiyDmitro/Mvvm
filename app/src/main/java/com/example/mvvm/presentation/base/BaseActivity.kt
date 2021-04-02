package com.example.mvvm.presentation.base

import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvm.MVVMApplication
import com.example.mvvm.di.components.ViewModelComponent

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        var currentActivity: Class<*>? = null
    }

    abstract fun injectDependency(component: ViewModelComponent)

    override fun onStart() {
        super.onStart()
        currentActivity = this::class.java
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDaggerDependencies()
    }

    override fun onDestroy() {
        if (currentActivity == javaClass) {
            currentActivity = null
        }
        super.onDestroy()
    }

    private fun createDaggerDependencies() {
        (application as MVVMApplication).getViewModelComponent()?.let { injectDependency(it) }
    }
}