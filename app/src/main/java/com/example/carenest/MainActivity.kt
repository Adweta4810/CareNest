package com.example.carenest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.carenest.ui.screens.AuthScreen
import com.example.carenest.ui.screens.HomeScreen
import com.example.carenest.ui.theme.CareNestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CareNestTheme {
                var isLoggedIn by remember { mutableStateOf(false) }

                if (isLoggedIn) {
                    HomeScreen()
                } else {
                    AuthScreen(
                        onAuthSuccess = {
                            isLoggedIn = true
                        }
                    )
                }
            }
        }
    }
}