package com.alperencitak.sis.repository

import com.alperencitak.sis.model.SelectedLesson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class SelectedLessonRepository {
    val client = HttpClient(CIO){
        install(ContentNegotiation){
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun getSelectionById(id: Int) : SelectedLesson{
        return client.get("http://10.0.2.2:8080/selectedlessons/$id").body()
    }

    suspend fun getSelectionsByStudentId(studentId: Int) : List<SelectedLesson>{
        return client.get("http://10.0.2.2:8080/selectedlessons/student/$studentId").body()
    }

    suspend fun getSelectionsByLessonId(lessonId: Int) : List<SelectedLesson>{
        return client.get("http://10.0.2.2:8080/selectedlessons/lesson/$lessonId").body()
    }

    suspend fun deleteSelectionById(id: Int){
        client.delete("http://10.0.2.2:8080/selectedlessons/delete/$id")
    }

    suspend fun addSelection(selection: SelectedLesson) : SelectedLesson{
        return client.post("http://10.0.2.2:8080/selectedlessons/save_selectedlesson"){
            contentType(ContentType.Application.Json)
            setBody(selection)
        }.body()
    }

}