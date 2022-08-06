package com.conamobile.data.network

import com.conamobile.domain.models.GithubUser
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Flow<List<GithubUser>>
}