package com.example.bmicalculatormvvmhilt.ui

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculatormvvmhilt.R
import com.example.bmicalculatormvvmhilt.databinding.ActivityResultBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class ResultActivity : AppCompatActivity() {


    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bmiValue = intent.getDoubleExtra("BMI", 0.0)
        val bmiCategory = intent.getStringExtra("CATEGORY")

        binding.tvBmiValue.text = "Nilai BMI Anda: $bmiValue"
        binding.tvBmiCategory.text = "Kategori BMI: $bmiCategory"

        binding.btnInfo.setOnClickListener {
            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.bottomsheet_developer, null)
            dialog.setContentView(view)
            dialog.show()
        }
    }
}
