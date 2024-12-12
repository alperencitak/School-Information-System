package com.alperencitak.sis.model

import kotlinx.serialization.Serializable

@Serializable
data class UserInstructor(
    val userId : Int,
    val username : String,
    val passwordHash : String,
    val role : String,
    val instructorId : Int
)
