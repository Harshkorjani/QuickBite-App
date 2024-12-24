package com.android.quickbite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.android.quickbite.databinding.ActivityChooseLocation2Binding
import com.android.quickbite.databinding.ActivityLoginBinding

class chooseLocationActivity2 : AppCompatActivity() {
    private val binding: ActivityChooseLocation2Binding by lazy {
        ActivityChooseLocation2Binding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val locationList = arrayOf(
            "Dehradun", "Nainital", "Mussoorie", "Rishikesh", "Haridwar", "Almora", "Pithoragarh", "Bageshwar",
            "Ranikhet", "Haldwani", "Kotdwar", "Tehri", "Chamoli", "Uttarkashi", "Rudraprayag", "Joshimath",
            "Kedarnath", "Badrinath", "Pauri", "Lansdowne", "Mukteshwar", "Auli", "Devprayag", "Gopeshwar",
            "Champawat", "Chakrata", "Dwarahat", "Munsiyari", "Dhanaulti", "Gairsain", "Lohaghat", "Gangotri",
            "Yamunotri", "Gaumukh"
        )
        val adaptar = ArrayAdapter(this, android.R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView = binding.listofLocation
        autoCompleteTextView.setAdapter(adaptar)

    }
}