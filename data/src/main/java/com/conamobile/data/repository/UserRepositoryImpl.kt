package com.conamobile.data.repository

import com.conamobile.data.network.ApiService
import com.conamobile.domain.models.GithubUser
import com.conamobile.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: ApiService) : UserRepository {
    override fun getUsers(): Flow<List<GithubUser>> {
        return apiService.getUsers()
    }

}