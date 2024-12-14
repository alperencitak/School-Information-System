package com.alperencitak.sis.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alperencitak.sis.R
import com.alperencitak.sis.repository.UserStudentRepository
import com.alperencitak.sis.viewmodel.UserStudentViewModel

@Composable
fun LoginStudentScreen() {
    val userStudentViewModel: UserStudentViewModel = remember {
        UserStudentViewModel(UserStudentRepository())
    }
    val userStudent by userStudentViewModel.userStudent.collectAsState()
    val isLoading by userStudentViewModel.loading.collectAsState()

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }

    Surface{
        Box(modifier = Modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.background1),
                contentDescription = "background",
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "STUDENT LOGIN",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Box(modifier = Modifier.height(256.dp).width(196.dp)){
                Image(
                    painter = painterResource(id = R.drawable.removebgstudent),
                    contentDescription = "Teacher Icon",
                    modifier = Modifier.matchParentSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
            TextField(
                value = username,
                onValueChange = {username = it},
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Account Icon"
                    )
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = password,
                onValueChange = {password = it},
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon"
                    )
                },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                onClick = {
                    if(username.isNotEmpty() && password.isNotEmpty()){
                        userStudentViewModel.login(username, password)
                    }
                }
            ) { Text(text = if (isLoading) "LOADING..." else "LOGIN") }

            if (userStudent != null) {
                text = "Id: ${userStudent!!.userId}\n" +
                        "Username: ${userStudent!!.username}\n" +
                        "Role: ${userStudent!!.role}\n" +
                        "InstructorId: ${userStudent!!.studentId}"
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = text)
        }
    }
}
