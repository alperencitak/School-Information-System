package com.alperencitak.sis.model

import kotlinx.serialization.Serializable

@Serializable
data class Transcript(
    val transcriptId: Int,
    val studentId: Int,
    val lessonId: Int,
    val grade: String,
    val semester: String
)
