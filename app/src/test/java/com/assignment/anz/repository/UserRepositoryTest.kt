/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.assignment.anz.repository

import com.assignment.anz.fake.FakeDataSource
import com.assignment.anz.fake.FakeUserApiService
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class UserRepositoryTest {

    @Test
    fun getUsersVerifyUserList() =
        runTest {
            val repository = UserRepositoryImpl(
                apiService = FakeUserApiService(shouldReturnError = false)
            )
            val result = repository.getUsers().first()
            assertEquals(Result.success(FakeDataSource.usersList), result)
        }

    @Test
    fun getUsersVerifyError() =
        runTest {
            val repository = UserRepositoryImpl(
                apiService = FakeUserApiService(shouldReturnError = true)
            )
            val result = repository.getUsers().first()
            assertTrue(result.isFailure)
            assertEquals("API Error", result.exceptionOrNull()?.message)
        }
}
