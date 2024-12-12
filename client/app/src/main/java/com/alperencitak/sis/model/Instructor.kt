package com.alperencitak.sis.model

import kotlinx.serialization.Serializable

@Serializable
data class Instructor(
    val instructorId : Int,
    val fullName : String,
    val title : String,
    val department : String,
    val email : String
)
