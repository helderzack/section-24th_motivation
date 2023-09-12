package com.helder.section24_motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.helder.section24_motivation.R
import com.helder.section24_motivation.databinding.ActivityMainBinding
import com.helder.section24_motivation.security.SecurityPreferences
import com.helder.section24_motivation.util.MotivationConstants

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

        SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, userName)
        val intent = Intent(this@MainActivity, UserActivity::class.java)
        startActivity(intent)
    }
}