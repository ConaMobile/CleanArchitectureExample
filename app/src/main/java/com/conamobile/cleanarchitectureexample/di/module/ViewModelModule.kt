package com.conamobile.cleanarchitectureexample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.conamobile.cleanarchitectureexample.vm.UserViewModel
import com.conamobile.cleanarchitectureexample.vm.ViewModelFactory
import com.conamobile.cleanarchitectureexample.vm.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    fun bindUserViewModel(userViewModel: UserViewModel): ViewModel
}