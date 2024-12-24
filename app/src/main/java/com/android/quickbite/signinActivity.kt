package com.android.quickbite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.quickbite.databinding.ActivityLoginBinding
import com.android.quickbite.databinding.ActivitySigninBinding

class signinActivity : AppCompatActivity() {
    private val binding: ActivitySigninBinding by lazy {
        ActivitySigninBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.alreadyhaveaccount.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}