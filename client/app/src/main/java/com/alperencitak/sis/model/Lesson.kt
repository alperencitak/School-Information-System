package com.alperencitak.sis.model

import kotlinx.serialization.Serializable

@Serializable
data class Lesson (
    val lessonId: Int,
    val lessonCode: String,
    val lessonName: String,
    val isMandatory: Boolean,
    val credit: Int,
    val department: String,
    val selections: SelectedLesson,
    val quota: Int
)