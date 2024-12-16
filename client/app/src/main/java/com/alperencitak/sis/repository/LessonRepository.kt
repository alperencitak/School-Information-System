package com.alperencitak.sis.repository

import com.alperencitak.sis.model.Lesson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class LessonRepository {
    val client = HttpClient(CIO){
        install(ContentNegotiation){
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun getLessonById(id: Int) : Lesson {
        return client.get("http://10.0.2.2:8080/lessons/$id").body()
    }

    suspend fun getLessonByCode(code: Int) : Lesson {
        return client.get("http://10.0.2.2:8080/lessons/code/$code").body()
    }

    suspend fun getAllLessons() : List<Lesson> {
        return client.get("http://10.0.2.2:8080/lessons").body()
    }
}