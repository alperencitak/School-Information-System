package com.alperencitak.sis.repository

import com.alperencitak.sis.model.Transcript
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

class TranscriptRepository {
    val client = HttpClient(CIO){
        install(ContentNegotiation){
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun getTranscriptById(id: Int) : Transcript{
        return client.get("http://10.0.2.2:8080/transcripts/$id").body()
    }

    suspend fun getTranscriptsByStudentId(studentId: Int) : List<Transcript>{
        return client.get("http://10.0.2.2:8080/transcripts/student/$studentId").body()
    }

    suspend fun getTranscriptsByLessonId(lessonId: Int) : List<Transcript>{
        return client.get("http://10.0.2.2:8080/transcripts/lesson/$lessonId").body()
    }

    suspend fun deleteTranscriptById(id: Int){
        client.delete("http://10.0.2.2:8080/transcripts/delete/$id")
    }

    suspend fun addTranscript(transcript: Transcript) : Transcript{
        return client.post("http://10.0.2.2:8080/transcripts/add_transcript"){
            contentType(ContentType.Application.Json)
            setBody(transcript)
        }.body()
    }

}