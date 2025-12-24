package com.zerocool.androidsprintlessons.ui

import android.util.Log
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)
fun MainCheckBox() {
    var isChecked: Boolean by remember { mutableStateOf(true) }

    Checkbox(
        checked = isChecked,
        onCheckedChange = { it ->
            Log.i("!!!", "MainCheckBox: $it")
            isChecked = it
        },
        modifier = Modifier.graphicsLayer(scaleX = 4f, scaleY = 4f)
    )
}