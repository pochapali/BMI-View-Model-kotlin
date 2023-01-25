package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeartRateApp()
        }
    }
}

@Composable
fun HeartRateApp() {
    var ageInput by remember { mutableStateOf(value = "") }
    val age = ageInput.toIntOrNull() ?: 044
    val upper = if (age>0) (220-age) * 0.85 else 0
    val lower = if (age>0) (220-age) * 0.65 else 0

    Column() {
        Text(
            text="HRL",
            style= MaterialTheme.typography.h6
        )
        TextField(
            value = ageInput,
            onValueChange = {ageInput=it},
            label={Text(text="Age")}
        )
        Text(
            text = "Limits are $lower - $upper"
        )

    }
}

