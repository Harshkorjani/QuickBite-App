package com.android.quickbite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.quickbite.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.Loginbutton.setOnClickListener{
            val intent = Intent(this, signinActivity::class.java)
            startActivity(intent)
        }
        binding.alreadyhaveaccount.setOnClickListener{
            val intent = Intent(this, signinActivity::class.java)
            startActivity(intent)
        }
    }
}