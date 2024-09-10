package com.seymagunduz.cities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.seymagunduz.cities.databinding.ActivityMainBinding
import com.seymagunduz.cities.databinding.ActivityPromotionalBinding

class PromotionalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPromotionalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPromotionalBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val selectedCity = intent.getSerializableExtra("cities") as Cities
        binding.imageView.setImageResource(selectedCity.image)
        binding.textViewName.text = selectedCity.name
        binding.textViewCountry.text = selectedCity.country
        binding.textViewPopulation.text=  "Population: ${selectedCity.population}"
        binding.textViewFood.text = "Famous Food: ${selectedCity.famousFood}"


    }
}