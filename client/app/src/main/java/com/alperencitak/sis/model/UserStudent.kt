package com.alperencitak.sis.model

import kotlinx.serialization.Serializable

@Serializable
data class UserStudent(
    val userId: Int,
    val username : String,
    val role : String,
    val studentId : Int?
)
