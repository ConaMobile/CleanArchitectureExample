package com.conamobile.domain.interactor

import com.conamobile.domain.models.GithubUser
import com.conamobile.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserInteractor @Inject constructor(private val userRepository: UserRepository) {

    fun getUsers(): Flow<Result<List<GithubUser>>> {
        return userRepository.getUsers().map {
            Result.success(it)
        }.catch {
            emit(Result.failure(it))
        }.flowOn(Dispatchers.IO)
    }
}
