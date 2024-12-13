package com.alperencitak.sis.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alperencitak.sis.repository.UserInstructorRepository
import com.alperencitak.sis.viewmodel.UserInstructorViewModel

@Composable
fun LoginInstructorScreen() {
    val userInstructorViewModel: UserInstructorViewModel = remember { UserInstructorViewModel(UserInstructorRepository()) }
    val userInstructor by userInstructorViewModel.userInstructor.collectAsState()
    val isLoading by userInstructorViewModel.loading.collectAsState()

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }

    Surface{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = username,
                onValueChange = {username = it},
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = password,
                onValueChange = {password = it},
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if(username.isNotEmpty() && password.isNotEmpty()){
                    userInstructorViewModel.login(username, password)
                }
            }
            ) { Text(text = if (isLoading) "LOADING..." else "LOGIN") }

            if (userInstructor != null) {
                text = "Id: ${userInstructor!!.instructorId}\n" +
                        "Username: ${userInstructor!!.username}\n" +
                        "Role: ${userInstructor!!.role}\n" +
                        "InstructorId: ${userInstructor!!.instructorId}"
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = text)
        }
    }
}