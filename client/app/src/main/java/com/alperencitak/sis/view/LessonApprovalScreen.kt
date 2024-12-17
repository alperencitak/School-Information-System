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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alperencitak.sis.R
import com.alperencitak.sis.model.SelectedLesson
import com.alperencitak.sis.repository.LessonRepository
import com.alperencitak.sis.repository.SelectedLessonRepository
import com.alperencitak.sis.repository.StudentRepository
import com.alperencitak.sis.viewmodel.LessonViewModel
import com.alperencitak.sis.viewmodel.SelectedLessonViewModel
import com.alperencitak.sis.viewmodel.StudentViewModel
import kotlinx.coroutines.launch

@Composable
fun LessonApprovalScreen(instructorId: Int) {
    val selectedLessonViewModel = remember {
        SelectedLessonViewModel(SelectedLessonRepository())
    }
    val lessonViewModel = remember {
        LessonViewModel(LessonRepository())
    }
    val studentViewModel = remember {
        StudentViewModel(StudentRepository())
    }
    val lessons by lessonViewModel.lessons.collectAsState()
    val students by studentViewModel.students.collectAsState()
    studentViewModel.getStudentsByInstructorId(instructorId)

    var approvalLesson by remember { mutableStateOf(emptyList<SelectedLesson>()) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold (
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = { paddingValues ->
            Surface{
                Box(modifier = Modifier.fillMaxSize()){
                    Image(
                        painter = painterResource(id = R.drawable.background1),
                        contentDescription = "Background Image",
                        modifier = Modifier.matchParentSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 64.dp)
                        .padding(paddingValues),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "LESSON APPROVAL",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.Center).padding(top = 32.dp)
                        )
                    }
                    LazyColumn(modifier = Modifier.weight(1f).padding(vertical = 32.dp)){
                        items(students){ student ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(4.dp)
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = student.firstName + " " + student.lastName,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                                    )
                                    student.selectedLessons.forEach{ selectedLesson ->
                                        val lesson = lessons.find { it.lessonId == selectedLesson.lessonId }
                                        var isPressed by remember { mutableStateOf(selectedLesson.isApproved) }
                                        var approvalText by remember { mutableStateOf(if (isPressed) "Approved" else "Not Approved") }
                                        if(lesson != null){
                                            Text(
                                                text = lesson.lessonName + "    " + if (lesson.isMandatory) "(Mandatory)" else "(Elective)",
                                                fontSize = 17.sp,
                                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                                            )
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(
                                                    text = approvalText,
                                                    fontSize = 16.sp,
                                                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 6.dp)
                                                )
                                                Spacer(modifier = Modifier.width(4.dp))
                                                ElevatedButton(
                                                    onClick = {
                                                        val selection = SelectedLesson(
                                                            selectedLesson.selectionId,
                                                            selectedLesson.studentId,
                                                            selectedLesson.lessonId,
                                                            selectedLesson.selectionDate,
                                                            !isPressed
                                                        )
                                                        if(approvalLesson.any{ it.selectionId == selection.selectionId }){
                                                            approvalLesson = approvalLesson.map {
                                                                if(it.selectionId == selection.selectionId) selection else it
                                                            }
                                                        }else{
                                                            approvalLesson = approvalLesson + selection
                                                        }
                                                        isPressed = !isPressed
                                                        approvalText = if (isPressed) "Approved" else "Not Approved"
                                                    },
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (isPressed) Color.Black else Color.White
                                                    )
                                                ) { Text(
                                                    text = "Approve",
                                                    fontSize = 17.sp,
                                                    color = if (isPressed) Color.White else Color.Black,
                                                    modifier = Modifier.padding(vertical = 6.dp)
                                                ) }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    ElevatedButton(
                        onClick = {
                            if(approvalLesson.isNotEmpty()){
                                selectedLessonViewModel.addSelections(approvalLesson)
                                approvalLesson = emptyList()
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "SAVED LESSON APPROVALS",
                                        duration = SnackbarDuration.Short
                                    )
                                }
                            }
                        },
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) { Text(
                        text = "SAVE",
                        fontSize = 22.sp,
                        modifier = Modifier.padding(horizontal = 6.dp,vertical = 4.dp)
                    ) }
                }
            }
        }
    )
}