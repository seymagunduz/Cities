package com.seymagunduz.cities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.seymagunduz.cities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var cityList : ArrayList<Cities>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cityRecyclerView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val istanbul = Cities("Istanbul","15660000", "Turkish Kebab", "Turkey", R.drawable.istanbul)
        val london = Cities("London", "8982000", "Fish and Chips","England", R.drawable.london)
        val milano = Cities("Milano", "1352000", "Pizza", "Italy", R.drawable.milano)
        val moscow = Cities("Moscow", "13100000", "Borsh Soup", "Russian Federation", R.drawable.moscow)
        val newdelhi = Cities("New Delhi", "33807000", "Gol Gappa", "India", R.drawable.newdelhi)
        val newyork = Cities("New York", "19680000", "Hamburger", "United States", R.drawable.newyork)
        val paris = Cities("Paris", "2161000", "Croissant", "France", R.drawable.paris)
        val shanghai = Cities("Shanghai", "24870000", "Noodle", "China", R.drawable.shanghai)
        val tokyo = Cities("Tokyo", "14180000", "Sushi", "Japan", R.drawable.tokyo)
        val toronto = Cities("Toronto","2930000", "Poutine", "Canada", R.drawable.toronto)

        cityList = arrayListOf(istanbul,london,milano,moscow,newyork,newdelhi,paris,shanghai,tokyo,toronto)

        val adapter = CityAdapter(cityList)
        binding.cityRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.cityRecyclerView.adapter = adapter


    }
}