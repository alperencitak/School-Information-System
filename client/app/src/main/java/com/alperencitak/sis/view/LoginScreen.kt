package com.alperencitak.sis.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alperencitak.sis.R

@Composable
fun LoginScreen(navController: NavController) {
    Surface{
        Box(modifier = Modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.background1),
                contentDescription = "Background Image",
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 128.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-128).dp)
                ){
                    Image(
                        painter = painterResource(R.drawable.sis),
                        contentDescription = "SIS Image",
                        modifier = Modifier
                            .height(282.dp)
                            .width(256.dp)
                            .align(Alignment.Center),
                        contentScale = ContentScale.Crop
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                ){
                    ElevatedButton(
                        modifier = Modifier
                            .offset(x = (-20).dp),
                        onClick = {
                            navController.navigate("screen_LoginUserStudentScreen")
                        }
                    ) { Text(
                        text = "Student Login",
                        fontSize = 22.sp,
                        modifier = Modifier.padding(start = 12.dp)
                    ) }

                    ElevatedButton(
                        modifier = Modifier
                            .offset(x = 20.dp, y = 96.dp)
                            .align(alignment = Alignment.CenterEnd),
                        onClick = {
                            navController.navigate("screen_LoginUserInstructorScreen")
                        }
                    ) { Text(
                        text = "Instructor Login",
                        fontSize = 22.sp,
                        modifier = Modifier.padding(end = 12.dp)
                    ) }
                }
            }
        }
    }
}