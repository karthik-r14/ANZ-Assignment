package com.assignment.anz.fake

import com.assignment.anz.model.User

object FakeDataSource {
    val usersList = listOf(
        User(
            id = 1,
            name = "Harry Potter",
            email = "harry.potter@hogwarts.school",
            username = "harry",
            photo = "url1",
            address = "123 Hogwarts Street",
            state = "Hogwarts",
            country = "United Kingdom",
            phone = "1234567890"
        ), User(
            id = 2,
            name = "Ron Weasly",
            email = "ron.weasly@hogwarts.school",
            username = "ron",
            photo = "url2",
            address = "123 Hogwarts Street",
            state = "Hogwarts",
            country = "United Kingdom",
            phone = "9876543210"
        )
    )
}