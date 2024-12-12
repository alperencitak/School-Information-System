package com.alperencitak.sis.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alperencitak.sis.repository.InstructorRepository
import com.alperencitak.sis.viewmodel.InstructorViewModel

@Composable
fun InstructorScreen(){
    val instructorViewModel: InstructorViewModel = remember { InstructorViewModel(InstructorRepository()) }
    val instructor by instructorViewModel.instructor.collectAsState()

    var id by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
            TextField(
                value = id,
                onValueChange = { id = it },
                modifier = Modifier.weight(1f),
                label = { Text("Instructor ID") }
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Button(onClick = {
            instructorViewModel.getInstructorById(id.toInt())
        }) {
            Text("Get Instructor")
        }
        Spacer(modifier = Modifier.height(16.dp))

        if(instructor != null){
            Text(text = "Id: ${instructor?.instructorId}")
            Text(text = "Fullname: ${instructor?.fullName}")
            Text(text = "Title: ${instructor?.title}")
            Text(text = "Email: ${instructor?.email}")
            Text(text = "Department: ${instructor?.department}")
        }else{
            Text(text = "Instructor not found")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewInstructorScreen() {
//    // Provide mock data for Preview
//    InstructorScreen(instructorViewModel = InstructorViewModel(instructorRepository = InstructorRepository()).apply {
//        getInstructorById(1)
//    })
//}