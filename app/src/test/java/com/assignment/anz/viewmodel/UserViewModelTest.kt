package com.assignment.anz.viewmodel

import com.assignment.anz.fake.FakeDataSource
import com.assignment.anz.fake.FakeNetworkUserRepository
import com.assignment.anz.rules.TestDispatcherRule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class UserViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun getUsersVerifyUserUiStateSuccess() =
        runTest {
            val userViewModel = UserViewModel(
                repository = FakeNetworkUserRepository(shouldReturnError = false),
                ioDispatcher = testDispatcher.testDispatcher
            )
            assertEquals(
                UserUiState.Success(FakeDataSource.usersList),
                userViewModel.uiState.value
            )
        }

    @Test
    fun getUsersVerifyUserUiStateError() =
        runTest {
            val userViewModel = UserViewModel(
                repository = FakeNetworkUserRepository(shouldReturnError = true),
                ioDispatcher = testDispatcher.testDispatcher
            )
            assert(userViewModel.uiState.value is UserUiState.Error)
            assertEquals(
                "Network Error",
                (userViewModel.uiState.value as UserUiState.Error).message
            )
        }

    @Test
    fun selectUserUpdatesSelectedUser() {
        val userViewModel = UserViewModel(
            repository = FakeNetworkUserRepository(),
            ioDispatcher = testDispatcher.testDispatcher
        )
        val testUser = FakeDataSource.usersList[0]
        userViewModel.selectUser(testUser)
        assertEquals(testUser, userViewModel.selectedUser)
    }
}
