package com.alperencitak.sis.repository

import com.alperencitak.sis.model.Student
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Inject

class StudentRepository @Inject constructor() {
    val client = HttpClient(CIO){
        install(ContentNegotiation){
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun getStudentById(id: Int): Student {
        return client.get("http://10.0.2.2:8080/students/$id").body()
    }

    suspend fun getStudentsByInstructorId(id: Int) : List<Student> {
        return client.get("http://10.0.2.2:8080/students/instructor/$id").body()
    }

}