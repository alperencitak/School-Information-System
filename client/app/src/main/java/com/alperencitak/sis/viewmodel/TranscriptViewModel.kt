package com.alperencitak.sis.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alperencitak.sis.model.Transcript
import com.alperencitak.sis.repository.TranscriptRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TranscriptViewModel @Inject constructor(
    private val transcriptRepository: TranscriptRepository
) : ViewModel() {
    private val _transcript = MutableStateFlow<Transcript?>(null)
    val transcript: StateFlow<Transcript?> = _transcript

    private val _transcriptsByStudent = MutableStateFlow<List<Transcript>>(emptyList())
    val transcriptsByStudent: StateFlow<List<Transcript>> = _transcriptsByStudent

    private val _transcriptsByLesson = MutableStateFlow<List<Transcript>>(emptyList())
    val transcriptsByLesson: StateFlow<List<Transcript>> = _transcriptsByLesson

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun getTranscriptById(id: Int){
        viewModelScope.launch {
            try {
                _loading.value = true
                _transcript.value = transcriptRepository.getTranscriptById(id)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }

    fun getTranscriptByStudentId(studentId: Int){
        viewModelScope.launch {
            try {
                _loading.value = true
                _transcriptsByStudent.value = transcriptRepository.getTranscriptsByStudentId(studentId)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }

    fun getTranscriptByLessonId(lessonId: Int){
        viewModelScope.launch {
            try {
                _loading.value = true
                _transcriptsByLesson.value = transcriptRepository.getTranscriptsByLessonId(lessonId)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }

    fun deleteTranscriptById(id: Int){
        viewModelScope.launch {
            try {
                _loading.value = true
                transcriptRepository.deleteTranscriptById(id)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }

    fun addTranscript(transcript: Transcript){
        viewModelScope.launch {
            try {
                _loading.value = true
                _transcript.value = transcriptRepository.addTranscript(transcript)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }

}