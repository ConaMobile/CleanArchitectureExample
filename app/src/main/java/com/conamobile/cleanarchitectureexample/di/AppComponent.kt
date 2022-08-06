package com.conamobile.cleanarchitectureexample.di

import com.conamobile.cleanarchitectureexample.App
import com.conamobile.cleanarchitectureexample.di.module.ApplicationModule
import com.conamobile.cleanarchitectureexample.di.module.DataModule
import com.conamobile.cleanarchitectureexample.di.module.ViewModelModule
import com.conamobile.cleanarchitectureexample.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DataModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AppComponent
    }

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}