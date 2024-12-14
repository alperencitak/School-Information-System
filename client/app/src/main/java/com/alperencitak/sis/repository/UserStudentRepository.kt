package com.alperencitak.sis.repository

import com.alperencitak.sis.model.UserStudent
import com.alperencitak.sis.request.UserLoginRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Inject

class UserStudentRepository @Inject constructor() {
    private val client = HttpClient(CIO){
        install(ContentNegotiation){
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun login(username: String, password: String) : UserStudent{
        return client.post("http://10.0.2.2:8080/user_students/login"){
            contentType(ContentType.Application.Json)
            setBody(UserLoginRequest(username, password))
        }.body()
    }
}