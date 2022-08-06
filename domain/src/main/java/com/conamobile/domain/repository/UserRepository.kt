package com.conamobile.domain.repository

import com.conamobile.domain.models.GithubUser
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUsers(): Flow<List<GithubUser>>
}