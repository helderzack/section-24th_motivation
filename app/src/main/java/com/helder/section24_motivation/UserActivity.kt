package com.helder.section24_motivation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.helder.section24_motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)

        with(binding) {
            imageAllPhrasesAction.setOnClickListener {
                Toast.makeText(applicationContext, "Clicked on All", Toast.LENGTH_SHORT).show()
            }

            imageHappyPhrasesAction.setOnClickListener {
                Toast.makeText(applicationContext, "Clicked on Happy", Toast.LENGTH_SHORT).show()
            }

            imageSunnyPhrasesAction.setOnClickListener {
                Toast.makeText(applicationContext, "Clicked on Sunny", Toast.LENGTH_SHORT).show()
            }

            val userName = intent.getStringExtra("userName")!!
            textHelloUser.text = getString(R.string.user_greeting, userName)
            setContentView(root)
        }
    }
}