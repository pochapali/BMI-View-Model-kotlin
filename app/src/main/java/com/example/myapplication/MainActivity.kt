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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

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
fun Bmi(hrViewModel: HrViewModel = viewModel()) {


    Column() {
        Text(
            text= stringResource(R.string.body_mass_index),
            fontSize = 24.sp,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            value = hrViewModel.heightInput,
            onValueChange = {hrViewModel.changeHeight(it.replace(',','.'))},
            label={Text(text="Height")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType=KeyboardType.Number   )
        )
        OutlinedTextField(
            value = hrViewModel.weightInput,
            onValueChange = {hrViewModel.changeWeight(it)},
            label={Text(text="Weight")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType=KeyboardType.Number   )
        )
        Text(text = stringResource(R.string.result ,String.format("%.2f",hrViewModel.result).replace(',','.')) )
    }
}

