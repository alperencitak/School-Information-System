package com.alperencitak.sis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alperencitak.sis.ui.theme.SisTheme
import com.alperencitak.sis.view.LoginInstructorScreen
import com.alperencitak.sis.view.LoginScreen
import com.alperencitak.sis.view.LoginStudentScreen
import com.alperencitak.sis.view.MainScreen

class MainActivity : ComponentActivity() {
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
                        MainScreen(role, relatedId)
                    }
                })
            }
        }
    }
}