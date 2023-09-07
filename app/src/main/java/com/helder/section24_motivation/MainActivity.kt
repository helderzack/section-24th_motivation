package com.helder.section24_motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.helder.section24_motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        with(binding) {
            buttonSave.setOnClickListener {
                navigateToUserActivity()
            }

            setContentView(root)
        }
    }

    private fun navigateToUserActivity() {
        val userName = binding.editName.text.toString()

        if (userName.isEmpty() || userName.isBlank()) {
            Toast.makeText(
                applicationContext,
                getString(R.string.toast_text),
                Toast.LENGTH_SHORT
            )
                .show()
            return
        }
        val intent = Intent(this@MainActivity, UserActivity::class.java)
        intent.putExtra("userName", userName)
        startActivity(intent)
    }
}