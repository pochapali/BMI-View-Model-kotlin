package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color=MaterialTheme.colors.background

                ) {
                    Bmi()
                }

        }
    }
}

@Composable
fun Bmi() {
    var heightInput: String by remember {
        mutableStateOf(value= "")
    }
    var weightInput : String by remember {
        mutableStateOf(value = "")
    }
    val height = heightInput.toFloatOrNull()?:0.0f
    val weight = weightInput.toIntOrNull()?:0
    val bmi = if (weight>0 && height>0) weight/ (height*height) else 0.0


    Column() {
        Text(
            text="Body mass index ",
            fontSize = 24.sp,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            value = heightInput,
            onValueChange = {heightInput=it},
            label={Text(text="Height")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType=KeyboardType.Number   )
        )
        OutlinedTextField(
            value = weightInput,
            onValueChange = {weightInput=it},
            label={Text(text="Weight")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType=KeyboardType.Number   )
        )
        Text(text = "Body mass index is "+bmi)
    }
}

