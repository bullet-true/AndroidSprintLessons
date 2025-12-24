package com.zerocool.androidsprintlessons.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zerocool.androidsprintlessons.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Back") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Back Button"
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Бесплатный курс",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Kotlin для начинающих",
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        shape = RoundedCornerShape(13.dp),
                        onClick = {},
                        modifier = Modifier
                            .height(56.dp)
                            .padding(horizontal = 40.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Начать",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(50.dp))

                val lessons = listOf("Урок 1", "Урок 2", "Урок 3", "Урок 4", "Урок 5")

                Text(
                    text = "Содержание курса",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.gilroy_bold)),
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    stickyHeader {
                        Text(
                            text = "Заголовок раздела 1",
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(8.dp)
                                .fillMaxWidth(),
                            fontSize = 24.sp
                        )
                    }

                    itemsIndexed(lessons) { index, lesson ->
                        Text(
                            text = "${index + 1}. $lesson",
                            modifier = Modifier.padding(start = 20.dp),
                            fontSize = 24.sp
                        )
                    }

                    stickyHeader {
                        Text(
                            text = "Заголовок раздела 2",
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(8.dp)
                                .fillMaxWidth(),
                            fontSize = 24.sp
                        )
                    }

                    items(50) { index ->
                        Text(
                            text = "${index + 1}",
                            modifier = Modifier.padding(start = 20.dp),
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }
    )
}