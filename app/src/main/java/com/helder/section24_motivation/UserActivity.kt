package com.helder.section24_motivation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.helder.section24_motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)

        with(binding) {
            setSupportActionBar(toolbar)

            val userName = intent.getStringExtra("userName")!!
            textHelloUser.text = getString(R.string.user_greeeting, userName)

            setContentView(root)
        }
    }
}