package com.conamobile.cleanarchitectureexample.di.module

import com.conamobile.data.network.ApiService
import com.conamobile.data.repository.UserRepositoryImpl
import com.conamobile.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [DataModule.BindModule::class])
class DataModule {

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Module
    abstract class BindModule{

        @Binds
        abstract fun bindApiRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
    }
}