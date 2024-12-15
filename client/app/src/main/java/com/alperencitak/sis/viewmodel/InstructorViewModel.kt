package com.alperencitak.sis.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alperencitak.sis.model.Instructor
import com.alperencitak.sis.repository.InstructorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InstructorViewModel @Inject constructor(
    private val instructorRepository: InstructorRepository
) : ViewModel() {

    private val _instructor = MutableStateFlow<Instructor?>(null)
    val instructor: StateFlow<Instructor?> = _instructor

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun getInstructorById(id: Int){
        viewModelScope.launch {
            try {
                _loading.value = true
                _instructor.value = instructorRepository.getInstructorById(id)
            }catch (e: Exception) {
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }

    fun getInstructorByEmail(email: String){
        viewModelScope.launch {
            try {
                _loading.value = true
                _instructor.value = instructorRepository.getInstructorByEmail(email)
            }catch (e: Exception) {
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }
}