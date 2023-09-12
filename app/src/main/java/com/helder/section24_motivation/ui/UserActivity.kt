package com.helder.section24_motivation.ui

import android.os.Bundle
import android.util.TypedValue
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.helder.section24_motivation.R
import com.helder.section24_motivation.data.PhraseCategory
import com.helder.section24_motivation.data.PhraseRepository
import com.helder.section24_motivation.databinding.ActivityUserBinding
import com.helder.section24_motivation.security.SecurityPreferences
import com.helder.section24_motivation.util.MotivationConstants

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    private val phraseRepository = PhraseRepository.getInstance()
    private var colorPrimaryInverse: Int = 0
    private var colorOnPrimaryContainer: Int = 0
    private var phraseCategory: PhraseCategory? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

            val userName =
                SecurityPreferences(applicationContext).getString(MotivationConstants.KEY.USER_NAME)
            textHelloUser.text = getString(R.string.user_greeting, userName)

            getNewPhrase()

            imageAllPhrasesAction.setColorFilter(colorPrimaryInverse)

            imageAllPhrasesAction.setOnClickListener {
                phraseCategory = null
                changeClickedIconColor(imageAllPhrasesAction)
                getNewPhrase()
            }

            imageHappyPhrasesAction.setOnClickListener {
                phraseCategory = PhraseCategory.Happy
                changeClickedIconColor(imageHappyPhrasesAction)
                getNewPhrase()
            }

            imageSunnyPhrasesAction.setOnClickListener {
                phraseCategory = PhraseCategory.Sunny
                changeClickedIconColor(imageSunnyPhrasesAction)
                getNewPhrase()
            }

            buttonNewPhrase.setOnClickListener { getNewPhrase() }

            setContentView(root)
        }
    }

    private fun getNewPhrase() {
        val phrase: String = if (phraseCategory == null) {
            phraseRepository.getData().random().phrase
        } else {
            phraseRepository.getData().filter { it.phraseCategory == phraseCategory }
                .random().phrase
        }

        binding.textMotivation.text = phrase
    }

    private fun changeClickedIconColor(clickedIcon: ImageView) {
        with(binding) {
            when (clickedIcon.id) {
                R.id.image_all_phrases_action -> {
                    imageAllPhrasesAction.setColorFilter(colorPrimaryInverse)
                    imageHappyPhrasesAction.setColorFilter(colorOnPrimaryContainer)
                    imageSunnyPhrasesAction.setColorFilter(colorOnPrimaryContainer)
                }

                R.id.image_happy_phrases_action -> {
                    imageAllPhrasesAction.setColorFilter(colorOnPrimaryContainer)
                    imageHappyPhrasesAction.setColorFilter(colorPrimaryInverse)
                    imageSunnyPhrasesAction.setColorFilter(colorOnPrimaryContainer)
                }

                R.id.image_sunny_phrases_action -> {
                    imageAllPhrasesAction.setColorFilter(colorOnPrimaryContainer)
                    imageHappyPhrasesAction.setColorFilter(colorOnPrimaryContainer)
                    imageSunnyPhrasesAction.setColorFilter(colorPrimaryInverse)
                }
            }
        }
    }
}