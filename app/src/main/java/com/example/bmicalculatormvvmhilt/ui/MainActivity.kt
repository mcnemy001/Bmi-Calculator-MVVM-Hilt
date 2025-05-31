package com.example.bmicalculatormvvmhilt.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.bmicalculatormvvmhilt.R
import com.example.bmicalculatormvvmhilt.viewmodel.BmiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //NIM : 10122384
    //Nama : Aziyusman Maulana
    //Kelas : ANDRO-4
    //Tanggal : 31-05-2025

    private lateinit var viewModel: BmiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[BmiViewModel::class.java]

        setContentView(R.layout.activity_main)

        val etWeight = findViewById<EditText>(R.id.edtWeight)
        val etHeight = findViewById<EditText>(R.id.edtHeight)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            val weightInput = etWeight.text.toString().replace(',', '.')
            val heightInput = etHeight.text.toString().replace(',', '.')

            val weight = weightInput.toFloatOrNull()
            val height = heightInput.toFloatOrNull()

            if (weight != null && height != null) {
                val (bmi, category) = viewModel.calculateBMI(weight, height)

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("BMI", bmi)
                intent.putExtra("CATEGORY", category)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Masukkan berat dan tinggi yang valid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
