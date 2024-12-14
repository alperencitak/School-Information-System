package com.alperencitak.sis.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alperencitak.sis.model.UserStudent
import com.alperencitak.sis.repository.UserStudentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserStudentViewModel @Inject constructor(
    private val userStudentRepository: UserStudentRepository
) : ViewModel(){

    private val _userStudent = MutableStateFlow<UserStudent?>(null)
    val userStudent: StateFlow<UserStudent?> = _userStudent

    private val _loading = MutableStateFlow(false)
    val loading : StateFlow<Boolean> = _loading

    fun login(username: String, password: String){
        viewModelScope.launch {
            try {
                _loading.value = true
                _userStudent.value = userStudentRepository.login(username, password)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }
}