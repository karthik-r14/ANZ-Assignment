package com.assignment.anz.fake

import com.assignment.anz.model.User
import com.assignment.anz.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeNetworkUserRepository(
    private val shouldReturnError: Boolean = false
) : UserRepository {

    override fun getUsers(): Flow<Result<List<User>>> = flow {
        if (shouldReturnError) {
            emit(Result.failure(Exception("Network Error")))
        } else {
            emit(Result.success(FakeDataSource.usersList))
        }
    }
}
