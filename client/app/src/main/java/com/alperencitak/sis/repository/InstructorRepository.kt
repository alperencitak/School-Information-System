package com.alperencitak.sis.repository

import com.alperencitak.sis.model.Instructor
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Inject

class InstructorRepository @Inject constructor() {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation){
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun getInstructorById(id: Int): Instructor {
        return client.get("http://10.0.2.2:8080/instructors/$id").body()
    }
}