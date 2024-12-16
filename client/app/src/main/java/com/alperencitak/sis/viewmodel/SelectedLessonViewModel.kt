package com.alperencitak.sis.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alperencitak.sis.model.SelectedLesson
import com.alperencitak.sis.repository.SelectedLessonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectedLessonViewModel @Inject constructor(
    private val selectedLessonRepository: SelectedLessonRepository
) : ViewModel() {
    private val _selection = MutableStateFlow<SelectedLesson?>(null)
    val selection: StateFlow<SelectedLesson?> = _selection

    private val _selectionsByStudent = MutableStateFlow<List<SelectedLesson>>(emptyList())
    val selectionsByStudent: StateFlow<List<SelectedLesson>> = _selectionsByStudent

    private val _selectionsByLesson = MutableStateFlow<List<SelectedLesson>>(emptyList())
    val selectionsByLesson: StateFlow<List<SelectedLesson>> = _selectionsByLesson

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun getSelectionById(id: Int){
        viewModelScope.launch {
            try {
                _loading.value = true
                _selection.value = selectedLessonRepository.getSelectionById(id)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }

    fun getSelectionByStudentId(studentId: Int){
        viewModelScope.launch {
            try {
                _loading.value = true
                _selectionsByStudent.value = selectedLessonRepository.getSelectionsByStudentId(studentId)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }

    fun getSelectionByLessonId(lessonId: Int){
        viewModelScope.launch {
            try {
                _loading.value = true
                _selectionsByLesson.value = selectedLessonRepository.getSelectionsByLessonId(lessonId)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }

    fun deleteSelectionById(id: Int){
        viewModelScope.launch {
            try {
                _loading.value = true
                selectedLessonRepository.deleteSelectionById(id)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }

    fun addSelections(selectedLessons: List<SelectedLesson>){
        viewModelScope.launch {
            try {
                _loading.value = true
                selectedLessons.forEach { selectedLesson ->
                    selectedLessonRepository.addSelection(selectedLesson)
                }
                _selectionsByStudent.value = selectedLessons
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }

}