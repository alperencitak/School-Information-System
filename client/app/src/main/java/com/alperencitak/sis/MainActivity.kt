package com.alperencitak.sis

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alperencitak.sis.ui.theme.SisTheme
import com.alperencitak.sis.view.LessonApprovalScreen
import com.alperencitak.sis.view.LessonSelectionScreen
import com.alperencitak.sis.view.LoginInstructorScreen
import com.alperencitak.sis.view.LoginScreen
import com.alperencitak.sis.view.LoginStudentScreen
import com.alperencitak.sis.view.MainScreen
import com.alperencitak.sis.view.StudentTranscriptScreen

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SisTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "screen_LoginScreen", builder = {
                    composable("screen_LoginScreen") {
                        LoginScreen(navController)
                    }
                    composable("screen_LoginUserInstructorScreen") {
                        LoginInstructorScreen(navController)
                    }
                    composable("screen_LoginUserStudentScreen") {
                        LoginStudentScreen(navController)
                    }
                    composable(
                        route = "main/{role}/{relatedId}",
                        arguments = listOf(
                            navArgument("role") { type = NavType.StringType},
                            navArgument("relatedId") { type = NavType.IntType}
                        )
                    ){ navBackStackEntry ->
                        val role = navBackStackEntry.arguments?.getString("role") ?: ""
                        val relatedId = navBackStackEntry.arguments?.getInt("relatedId") ?: 0
                        MainScreen(role, relatedId, navController)
                    }
                    composable(
                        route = "transcript/{studentId}",
                        arguments = listOf(navArgument("studentId"){ type = NavType.IntType })
                    ) { navBackStackEntry ->
                        val studentId = navBackStackEntry.arguments?.getInt("studentId") ?: 0
                        StudentTranscriptScreen(studentId)
                    }
                    composable(
                        route = "lessonselection/{department}/{studentId}",
                        arguments = listOf(
                            navArgument("department"){ type = NavType.StringType },
                            navArgument("studentId"){ type = NavType.IntType }
                        )
                    ) { navBackStackEntry ->
                        val department = navBackStackEntry.arguments?.getString("department") ?: ""
                        val studentId = navBackStackEntry.arguments?.getInt("studentId") ?: 0
                        LessonSelectionScreen(department, studentId)
                    }
                    composable(
                        route = "lessonapproval/{instructorId}",
                        arguments = listOf(
                            navArgument("instructorId"){ type = NavType.IntType }
                        )
                    ) { navBackStackEntry ->
                        val instructorId = navBackStackEntry.arguments?.getInt("instructorId") ?: 0
                        LessonApprovalScreen(instructorId)
                    }
                })
            }
        }
    }
}