package com.alperencitak.sis.model

import kotlinx.serialization.Serializable

@Serializable
data class SelectedLesson (
    val selectionId : Int,
    val studentId : Int,
    val lessonId : Int,
    val selectionDate : String,
    val isApproved : Boolean
)