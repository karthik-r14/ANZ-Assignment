package com.assignment.anz.fake

import com.assignment.anz.model.User
import com.assignment.anz.network.UserApiService

class FakeUserApiService(
    private val shouldReturnError: Boolean = false
) : UserApiService {
    override suspend fun getUsers(): List<User> {
        if (shouldReturnError) {
            throw Exception("API Error")
        }
        return FakeDataSource.usersList
    }
}
