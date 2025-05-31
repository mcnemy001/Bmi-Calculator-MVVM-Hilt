package com.example.bmicalculatormvvmhilt.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class BmiViewModel @Inject constructor() : ViewModel() {

    fun calculateBMI(weight: Float, heightCm: Float): Pair<Double, String> {
        val heightM = heightCm / 100
        val bmi = weight / (heightM * heightM)
        val category = when {
            bmi < 18.5 -> "Kurus"
            bmi < 25 -> "Normal"
            bmi < 30 -> "Gemuk"
            else -> "Obesitas"
        }
        val bmiRounded = String.format(Locale.US, "%.2f", bmi).toDouble() // <-- pastikan pakai Locale.US supaya decimal pakai titik
        return Pair(bmiRounded, category)
    }
}
