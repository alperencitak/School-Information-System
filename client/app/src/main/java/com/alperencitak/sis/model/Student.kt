package com.alperencitak.sis.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Student(
    val studentId : Int,
    val firstName : String,
    val lastName : String,
    val email : String,
    val instructorId : Int,
    val enrollmentDate : String,
    @SerialName("selections")
    val selectedLessons : List<SelectedLesson>,
    val userStudent: UserStudent
)
