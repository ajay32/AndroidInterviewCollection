package com.example.interviewlist.kotlin.jetpackcompose

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomButton(label: String, click: () -> Unit) {
    Button(onClick = click) {
        Text(text = label)
    }
}

@Composable
fun ButtonsList() {
    Row {
        CustomButton("Button 1") { Log.d("TagButton", "Button 1 clicked")}
        CustomButton("Button 2", click = { Log.d("TagButton", "Button 2 clicked")})
        CustomButton("Button 3", click = { Log.d("TagButton", "Button 3 clicked")})
    }
}

@Preview
@Composable
fun PreviewButtonsThree() {
    ButtonsList()
}
