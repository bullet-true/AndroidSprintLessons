package com.zerocool.androidsprintlessons.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zerocool.androidsprintlessons.R
import com.zerocool.androidsprintlessons.ui.theme.AndroidSprintLessonsTheme
import com.zerocool.androidsprintlessons.ui.theme.subtitle

@Composable
fun HomeScreen() {
    AndroidSprintLessonsTheme {
        Scaffold { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    //.background(Color.LightGray)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                StudyAppHeader("Bender")
                Spacer(modifier = Modifier.height(30.dp))
                MainNavButton()
                Spacer(modifier = Modifier.height(30.dp))
                StartImageButton()
            }
        }
    }
}

@Composable
fun StudyAppHeader(
    title: String = "",
    subtitle: String = "",
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = subtitle,
            color = MaterialTheme.colorScheme.subtitle,
            style = MaterialTheme.typography.headlineMedium,
        )
    }
}

@Composable
fun StartImageButton() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            contentDescription = "",
            painter = painterResource(R.drawable.mr_robot),
            modifier = Modifier
                //.alpha(0.8f)
                .size(120.dp)
                .shadow(10.dp, CircleShape, spotColor = Color.Blue)
                .clip(CircleShape)
                .clickable(
                    onClick = {},
                    indication = ripple(),
                    interactionSource = remember { MutableInteractionSource() }
                )
        )
        Text(
            modifier = Modifier.padding(0.dp, 30.dp, 0.dp, 0.dp),
            text = "Hey!",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.subtitle,
        )
    }
}

@Composable
fun MainNavButton() {
    Row(
        modifier = Modifier.padding(5.dp)
    ) {
        Button(
            onClick = {},
            shape = RoundedCornerShape(13.dp),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 5.dp)

        ) {
            Text(
                text = "Уроки",
                fontFamily = FontFamily(Font(R.font.gilroy_bold)),
                //color = MaterialTheme.colorScheme.onBackground
            )
        }
        Button(
            onClick = {},
            shape = RoundedCornerShape(13.dp),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 5.dp)
        ) {
            Text(
                text = "Тесты",
                fontFamily = FontFamily(Font(R.font.gilroy_bold))
            )
        }
        Button(
            onClick = {},
            shape = RoundedCornerShape(13.dp),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 5.dp)
        ) {
            Text(
                text = "Практика",
                fontFamily = FontFamily(Font(R.font.gilroy_bold))
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GreetingsPreview() {
    StudyAppHeader("Bender")
}

@Composable
@Preview(showBackground = true)
fun MainNavButtonPreviewLight() {
    AndroidSprintLessonsTheme(
        darkTheme = false
    ) {
        MainNavButton()
    }

}

@Composable
@Preview(showBackground = true)
fun MainNavButtonPreviewDark() {
    AndroidSprintLessonsTheme(
        darkTheme = true
    ) {
        MainNavButton()
    }
}

@Composable
@Preview(showBackground = true)
fun StartImageButtonPreview() {
    StartImageButton()
}