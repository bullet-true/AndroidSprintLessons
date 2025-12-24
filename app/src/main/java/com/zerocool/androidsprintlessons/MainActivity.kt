package com.zerocool.androidsprintlessons


import android.os.Bundle
import android.util.Patterns.EMAIL_ADDRESS
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zerocool.androidsprintlessons.ui.StudyAppHeader
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
                            Spacer(Modifier.height(70.dp))
                            StudyAppHeader(
                                title = "Регистрация",
                                subtitle = "Введите почту"
                            )
                            Spacer(Modifier.height(200.dp))
                            CheckEmailField()
                        }
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CheckEmailField() {
    var textState by remember { mutableStateOf("") }
    var errorState by remember { mutableStateOf("") }

    OutlinedTextField(
        value = textState,
        onValueChange = {
            textState = it
            errorState = if (EMAIL_ADDRESS.matcher(it).matches()) "" else "Некорректный email"
        },
        shape = RoundedCornerShape(13.dp),
        textStyle = MaterialTheme.typography.headlineMedium,
        placeholder = {
            Text(
                text = "Заранее отображаемый текст",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Gray,
            )
        },
        singleLine = true, // в одну строку
        label = {
            Text(
                text = if (errorState.isEmpty()) "Это стандартная метка" else errorState,
                style = MaterialTheme.typography.headlineSmall
            )
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    textState = ""
                    errorState = ""
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "Иконка очистки поля"
                )
            }
        },
        leadingIcon = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Иконка Add"
                )
            }
        },
        isError = errorState.isNotEmpty()
    )
}

@Composable
@Preview
fun PrimaryButton() {
    Button(
        shape = RoundedCornerShape(13.dp),
        onClick = {},
        modifier = Modifier
            .height(56.dp)
            .padding(40.dp, 0.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Зарегистрироваться",
            style = MaterialTheme.typography.labelMedium
        )
    }
}