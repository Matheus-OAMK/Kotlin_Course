package com.example.bmi_calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    var heightInput: String by mutableStateOf("")
    var weightInput: String by mutableStateOf("")

    fun calculationBmi(): Float {
        val height = heightInput.toFloatOrNull() ?: 0.0f
        val weight = weightInput.toIntOrNull() ?: 0
        return if (weight > 0 && height > 0) {
            weight / (height * height)
        } else {
            0.0f
        }
    }

}
