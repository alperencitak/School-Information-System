package com.alperencitak.sis.view

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
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
import com.alperencitak.sis.R
import com.alperencitak.sis.model.SelectedLesson
import com.alperencitak.sis.repository.LessonRepository
import com.alperencitak.sis.repository.SelectedLessonRepository
import com.alperencitak.sis.viewmodel.LessonViewModel
import com.alperencitak.sis.viewmodel.SelectedLessonViewModel
import java.time.Instant

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LessonSelectionScreen(department: String, studentId: Int) {
    val selectedLessonViewModel = remember {
        SelectedLessonViewModel(SelectedLessonRepository())
    }
    val lessonViewModel = remember {
        LessonViewModel(LessonRepository())
    }
    val selectionsByStudent by selectedLessonViewModel.selectionsByStudent.collectAsState()
    val lessons by lessonViewModel.lessons.collectAsState()
    var selectedLessons by remember { mutableStateOf(emptyList<SelectedLesson>()) }
    val isSelectedLessons = selectionsByStudent.isNotEmpty()
    selectedLessonViewModel.getSelectionByStudentId(studentId)

    Surface{
        Box(modifier = Modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.background1),
                contentDescription = "Background Image",
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "LESSON SELECTION",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center).padding(top = 64.dp)
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(isSelectedLessons){
                Text(
                    text = "YOUR COURSE SELECTION HAS ALREADY BEEN MADE",
                    fontSize = 16.sp
                )
            }else{
                val departmentLessons = lessons.filter { it.department == department }
                val mandatoryLessons = departmentLessons.filter { it.isMandatory }
                LazyColumn{
                    itemsIndexed(departmentLessons){ index, lesson ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = lesson.lessonName,
                                    fontSize = 14.sp,
                                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                                )
                                Row {
                                    Text(
                                        text = if (lesson.isMandatory) "Mandatory" else "Elective",
                                        fontSize = 14.sp,
                                        modifier = Modifier.padding(horizontal = 32.dp, vertical = 6.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    var check by remember { mutableStateOf(selectionsByStudent.any { it.lessonId == lesson.lessonId }) }
                                    Checkbox(
                                        checked = check,
                                        onCheckedChange = { newChecked ->
                                            check = newChecked
                                            val selectedLesson = SelectedLesson(null, studentId,lesson.lessonId, Instant.now().toString(), false)
                                            if (newChecked){
                                                if (!selectedLessons.any { it.lessonId == lesson.lessonId }) {
                                                    selectedLessons = selectedLessons + selectedLesson
                                                }
                                            }else{
                                                selectedLessons = selectedLessons.filter { it.lessonId != lesson.lessonId }
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                ElevatedButton(
                    onClick = {
                        val mandatoryLessonsSelected = mandatoryLessons.all { mandatoryLesson ->
                            selectedLessons.any { it.lessonId == mandatoryLesson.lessonId }
                        }
                        if(mandatoryLessonsSelected){
                            selectedLessonViewModel.addSelections(selectedLessons)
                        }else{
                            println("Not all compulsory courses have been selected!")
                        }
                    }
                ) { Text(
                    text = "SAVE SELECTIONS",
                    fontSize = 22.sp,
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) }
            }
        }
    }
}