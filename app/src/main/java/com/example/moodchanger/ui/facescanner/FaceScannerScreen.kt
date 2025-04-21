package com.example.moodchanger.ui.facescanner

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp

@Composable
fun FaceScannerScreen() {
    var button1 by remember { mutableStateOf("") }
    var button2 by remember { mutableStateOf("") }


    Column(modifier = Modifier.padding(top = 200.dp)) {
        Button(onClick = {
            button1 += "1";
        }) {
            Text("Button 1 $button1")
        }

        Button(onClick = {
            button2 += "2";
        }) {
            Text("Button 2 $button2")
        }
        Spacer(modifier = Modifier.height(10.dp))

        MyRow {
            Text(button1)
        }


    }
}

@Composable
inline fun MyRow(content: @Composable () -> Unit) {
    content()
}

@Preview(
    showSystemUi = true, showBackground = true, wallpaper = Wallpapers.NONE,
    device = "id:pixel_8"
)
@Composable
fun PreviewFaceScannerScreen() {
    FaceScannerScreen()
}