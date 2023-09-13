package com.helder.section24_motivation

import android.os.Bundle
import android.util.TypedValue
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.helder.section24_motivation.data.PhraseCategory
import com.helder.section24_motivation.data.PhraseRepository
import com.helder.section24_motivation.databinding.ActivityUserBinding
import java.util.Locale

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    private lateinit var deviceLanguage: String
    private val phraseRepository = PhraseRepository.getInstance()
    private var colorPrimaryInverse: Int = 0
    private var colorOnPrimaryContainer: Int = 0
    private var phraseCategory: PhraseCategory? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        deviceLanguage =Locale.getDefault().language
        binding = ActivityUserBinding.inflate(layoutInflater)

        with(binding) {
            val typedValue = TypedValue()
            theme.resolveAttribute(
                com.google.android.material.R.attr.colorPrimaryInverse,
                typedValue,
                true
            )
            colorPrimaryInverse = ContextCompat.getColor(applicationContext, typedValue.resourceId)

            theme.resolveAttribute(
                com.google.android.material.R.attr.colorOnPrimaryContainer,
                typedValue,
                true
            )
            colorOnPrimaryContainer =
                ContextCompat.getColor(applicationContext, typedValue.resourceId)

            val userName = intent.getStringExtra("userName")!!
            textHelloUser.text = getString(R.string.user_greeting, userName)

            getNewPhrase()

            imageAllPhrasesAction.setColorFilter(colorPrimaryInverse)

            imageAllPhrasesAction.setOnClickListener {
                handleClickOnIcon(imageAllPhrasesAction)
            }

            imageHappyPhrasesAction.setOnClickListener {
                handleClickOnIcon(imageHappyPhrasesAction)
            }

            imageSunnyPhrasesAction.setOnClickListener {
                handleClickOnIcon(imageSunnyPhrasesAction)
            }

            buttonNewPhrase.setOnClickListener { getNewPhrase() }

            setContentView(root)
        }
    }

    private fun getNewPhrase() {
        val phrase: String = if (phraseCategory == null) {
            phraseRepository.getData(deviceLanguage).random().phrase
        } else {
            phraseRepository.getData(deviceLanguage).filter { it.phraseCategory == phraseCategory }
                .random().phrase
        }

        binding.textMotivation.text = phrase
    }

    private fun handleClickOnIcon(clickedIcon: ImageView) {
        with(binding) {
            imageAllPhrasesAction.setColorFilter(colorOnPrimaryContainer)
            imageHappyPhrasesAction.setColorFilter(colorOnPrimaryContainer)
            imageSunnyPhrasesAction.setColorFilter(colorOnPrimaryContainer)

            when (clickedIcon.id) {
                R.id.image_all_phrases_action -> {
                    imageAllPhrasesAction.setColorFilter(colorPrimaryInverse)
                    phraseCategory = null
                }

                R.id.image_happy_phrases_action -> {
                    phraseCategory = PhraseCategory.Happy
                    imageHappyPhrasesAction.setColorFilter(colorPrimaryInverse)
                }

                R.id.image_sunny_phrases_action -> {
                    phraseCategory = PhraseCategory.Sunny
                    imageSunnyPhrasesAction.setColorFilter(colorPrimaryInverse)
                }
            }
        }

        getNewPhrase()
    }
}