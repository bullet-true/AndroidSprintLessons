package com.zerocool.androidsprintlessons.ui

import android.util.Log
import android.util.Patterns.EMAIL_ADDRESS
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RegistrationScreen() {
    var userEmail by remember { mutableStateOf("") }
    var isEmailFormatValid by remember { mutableStateOf(true) }
    var validationMessage by remember { mutableStateOf("") }

    val testEmail = "123@ya.ru"

    Spacer(Modifier.height(70.dp))
    StudyAppHeader(
        title = "Регистрация",
        subtitle = "Введите почту"
    )
    Spacer(Modifier.height(200.dp))
    CheckEmailField(
        email = userEmail,
        isEmailValid = isEmailFormatValid,
        onEmailChange = {
            userEmail = it
            isEmailFormatValid = EMAIL_ADDRESS.matcher(it).matches()
            validationMessage = if (!isEmailFormatValid) {
                "Некорректный email"
            } else {
                ""
            }
        },
        onClearClick = {
            userEmail = ""
            isEmailFormatValid = true
            validationMessage = ""
        }
    )
    Spacer(Modifier.height(30.dp))
    PrimaryButton(
        text = "Зарегистрироваться",
        onRegisterClick = { it: String ->
            validationMessage = if (userEmail.isEmpty() || !isEmailFormatValid) {
                "Некорректный email"
            } else if (userEmail == testEmail) {
                "Такая почта уже существует"
            } else {
                "Регистрация успешно пройдена"
            }

            Log.i("!!!", "PrimaryButton: Нажата кнопка $it")
        }
    )
    Spacer(Modifier.height(30.dp))
    Text(
        text = validationMessage,
        style = MaterialTheme.typography.bodyLarge,
        color = if (validationMessage.contains("успешно")) Color.DarkGray else Color.Red,
        modifier = Modifier.alpha(if (validationMessage.isNotEmpty() && isEmailFormatValid) 1f else 0f),
    )
}

@Composable
fun CheckEmailField(
    email: String,
    isEmailValid: Boolean,
    onEmailChange: (String) -> Unit,
    onClearClick: () -> Unit,
) {
    OutlinedTextField(
        value = email,
        onValueChange = {
            onEmailChange(it)
        },
        shape = RoundedCornerShape(13.dp),
        textStyle = MaterialTheme.typography.headlineMedium,
        placeholder = {
            Text(
                text = "Введите email",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Gray,
            )
        },
        singleLine = true, // в одну строку
        label = {
            Text(
                text = if (isEmailValid) "Почта" else "Некорректный email",
                style = MaterialTheme.typography.headlineSmall
            )
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    onClearClick()
                },
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
        isError = !isEmailValid && email.isNotEmpty(),
    )
}

@Composable
fun PrimaryButton(
    text: String,
    onRegisterClick: (String) -> Unit,
) {
    Button(
        shape = RoundedCornerShape(13.dp),
        onClick = {
            onRegisterClick(text)
        },
        modifier = Modifier
            .height(56.dp)
            .padding(40.dp, 0.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium
        )
    }
}