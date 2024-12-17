package com.alperencitak.sis.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alperencitak.sis.R
import com.alperencitak.sis.repository.LessonRepository
import com.alperencitak.sis.repository.SelectedLessonRepository
import com.alperencitak.sis.repository.TranscriptRepository
import com.alperencitak.sis.viewmodel.LessonViewModel
import com.alperencitak.sis.viewmodel.SelectedLessonViewModel
import com.alperencitak.sis.viewmodel.TranscriptViewModel

@Composable
fun StudentTranscriptScreen(studentId: Int) {
    val transcriptViewModel = remember {
        TranscriptViewModel(TranscriptRepository())
    }
    val lessonViewModel = remember {
        LessonViewModel(LessonRepository())
    }
    val selectedLessonViewModel = remember {
        SelectedLessonViewModel(SelectedLessonRepository())
    }
    val transcriptsByStudent by transcriptViewModel.transcriptsByStudent.collectAsState()
    val lessons by lessonViewModel.lessons.collectAsState()
    val selectedLessons by selectedLessonViewModel.selectionsByStudent.collectAsState()
    selectedLessonViewModel.getSelectionByStudentId(studentId)
    transcriptViewModel.getTranscriptByStudentId(studentId)

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
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "TRANSCRIPT",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center).padding(top = 32.dp)
                )
            }
            LazyColumn(modifier = Modifier.weight(1f).padding(vertical = 56.dp)){
                itemsIndexed(selectedLessons){ _, selectedLesson ->
                    val lesson = lessons.find { it.lessonId == selectedLesson.lessonId }
                    if(lesson != null && selectedLesson.isApproved){
                        val grade = transcriptsByStudent.find { it.lessonId == lesson.lessonId }?.grade ?: "--"
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
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                                )
                                Text(
                                    text = grade,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 6.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}