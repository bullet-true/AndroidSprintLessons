package com.zerocool.androidsprintlessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.zerocool.androidsprintlessons.ui.theme.AndroidSprintLessonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidSprintLessonsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        AppNavigation()
                    }
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val currentScreen = remember { mutableStateOf("first") }

    when (currentScreen.value) {
        "first" -> FirstScreen(
            onNextClick = {
                currentScreen.value = "second"
            }
        )

        "second" -> SecondScreen(
            onNextClick = {
                currentScreen.value = "first"
            }
        )
    }
}

@Composable
fun FirstScreen(
    onNextClick: () -> Unit,
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onNextClick
        ) {
            Text("Перейти на SecondScreen")
        }
    }
}

@Composable
fun SecondScreen(
    onNextClick: () -> Unit,
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onNextClick
        ) {
            Text("Перейти на FirstScreen")
        }
    }
}