package com.example.myapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HrViewModel: ViewModel() {
    var result:Float=0.0f
    get(){
        return calculate_BMI()
    }
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")
    private var height: Float = 0.0f
        get() {
            return heightInput.toFloatOrNull()?:0.0f
        }
    private var weight: Int = 0
    get() {
        return weightInput.toIntOrNull()?:0
    }

    private fun calculate_BMI():Float {

        return if (weight>0 && height>0) weight/ (height*height) else 0.0f

    }
    fun changeHeight (value: String){
        heightInput=value
    }
    fun changeWeight (value: String){
        weightInput=value
    }


}