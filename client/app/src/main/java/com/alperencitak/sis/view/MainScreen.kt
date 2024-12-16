package com.alperencitak.sis.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alperencitak.sis.R
import com.alperencitak.sis.repository.InstructorRepository
import com.alperencitak.sis.repository.StudentRepository
import com.alperencitak.sis.viewcomponent.ElevatedCardComp
import com.alperencitak.sis.viewmodel.InstructorViewModel
import com.alperencitak.sis.viewmodel.StudentViewModel

@Composable
fun MainScreen(role: String, relatedId: Int, navController: NavController) {
    if(role == "student"){

        val studentViewModel = remember { StudentViewModel(StudentRepository()) }
        val instructorViewModel = remember { InstructorViewModel(InstructorRepository()) }
        val student by studentViewModel.student.collectAsState()
        val instructor by instructorViewModel.instructor.collectAsState()
        studentViewModel.getStudentById(relatedId)
        if(student!=null){
            instructorViewModel.getInstructorById(student!!.instructorId)
        }

        var studentId by remember { mutableStateOf("") }
        var fullName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }

        Surface{
            Box(
                modifier = Modifier.fillMaxSize()
            ){
                Image(
                    painter = painterResource(R.drawable.background1),
                    contentDescription = "Background Image",
                    modifier = Modifier.matchParentSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 48.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                Box(modifier = Modifier.height(156.dp).width(112.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.removebgstudent),
                        contentDescription = "Teacher Icon",
                        modifier = Modifier.matchParentSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Id Icon",
                    )
                    Text(
                        text = studentId,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = "Account Icon",
                    )
                    Text(
                        text = fullName,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon",
                    )
                    Text(
                        text = email,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.height(128.dp))
                ElevatedCardComp(
                    onClick = {
                        navController.navigate("transcript/${studentId}")
                    },
                    text = "TRANSCRIPT"
                )
                Spacer(modifier = Modifier.height(32.dp))
                ElevatedCardComp(
                    onClick = {
                        if(student != null){
                            if(instructor!=null){
                                navController.navigate("lessonselection/${instructor!!.department}/${studentId}")
                            }else{
                                println("instructor null")
                            }
                        }else{
                            println("student null")
                        }
                    },
                    text = "LESSON SELECTION"
                )
            }
        }
        if(student != null){
            studentId = student!!.studentId.toString()
            fullName = student!!.firstName + " " +student!!.lastName
            email = student!!.email
        }
    }else{

        val instructorViewModel = remember { InstructorViewModel(InstructorRepository()) }
        val instructor by instructorViewModel.instructor.collectAsState()
        instructorViewModel.getInstructorById(relatedId)

        var fullName by remember { mutableStateOf("") }
        var department by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }

        Surface{
            Box(
                modifier = Modifier.fillMaxSize()
            ){
                Image(
                    painter = painterResource(R.drawable.background1),
                    contentDescription = "Background Image",
                    modifier = Modifier.matchParentSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 48.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                Box(modifier = Modifier.height(156.dp).width(112.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.removebgteacher),
                        contentDescription = "Teacher Icon",
                        modifier = Modifier.matchParentSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = "Account Icon",
                    )
                    Text(
                        text = fullName,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon",
                    )
                    Text(
                        text = email,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = "Department Icon",
                    )
                    Text(
                        text = department,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.height(128.dp))
                ElevatedCardComp(
                    onClick = {

                    },
                    text = "STUDENTS"
                )
                Spacer(modifier = Modifier.height(16.dp))
                ElevatedCardComp(
                    onClick = {

                    },
                    text = "INFORMATIONS"
                )
            }
        }
        if(instructor != null){
            fullName = instructor!!.fullName
            email = instructor!!.email
            department = instructor!!.department
        }
    }
}