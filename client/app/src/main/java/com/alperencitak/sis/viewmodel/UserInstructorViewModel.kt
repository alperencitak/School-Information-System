package com.alperencitak.sis.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alperencitak.sis.model.UserInstructor
import com.alperencitak.sis.repository.UserInstructorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserInstructorViewModel @Inject constructor(
    private val userInstructorRepository: UserInstructorRepository
) : ViewModel(){

    private val _userInstructor = MutableStateFlow<UserInstructor?>(null)
    val userInstructor : StateFlow<UserInstructor?> = _userInstructor

    private val _loading = MutableStateFlow(false)
    val loading : StateFlow<Boolean> = _loading

    fun login(username: String, password: String){
        viewModelScope.launch {
            try {
                _loading.value = true
                _userInstructor.value = userInstructorRepository.login(username, password)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                _loading.value = false
            }
        }
    }
}