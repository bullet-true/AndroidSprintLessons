package com.zerocool.androidsprintlessons


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.zerocool.androidsprintlessons.ui.RegistrationScreen
import com.zerocool.androidsprintlessons.ui.theme.AndroidSprintLessonsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidSprintLessonsTheme {
                Scaffold(
                    content = { innerPadding: PaddingValues ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
//                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize(),
                        ) {
                            RegistrationScreen()
                        }
                    }
                )
            }
        }
    }
}