package com.alperencitak.sis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.alperencitak.sis.ui.theme.SisTheme
import com.alperencitak.sis.view.LoginInstructorScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SisTheme {
                LoginInstructorScreen()
            }
        }
    }
}