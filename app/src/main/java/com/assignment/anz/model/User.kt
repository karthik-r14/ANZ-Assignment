package com.assignment.anz.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int? = null,
    val name: String? = null,
    val email: String? = null,
    val username: String? = null,
    val photo: String? = null,
    val address: String? = null,
    val state: String? = null,
    val country: String? = null
)