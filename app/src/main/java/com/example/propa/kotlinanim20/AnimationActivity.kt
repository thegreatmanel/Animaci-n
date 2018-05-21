package com.example.propa.kotlinanim20

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View


import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.util.DisplayMetrics
import android.view.animation.LinearInterpolator
import com.example.propa.kotlinanim20.R.layout.fragment_animation

import com.example.propa.kotlinanim20.AnimationActivityFragment
import com.example.propa.kotlinanim20.R.id.calendar


class AnimationActivity : AppCompatActivity() {

        protected lateinit var calendar: View
        protected lateinit var frameLayout: View
        protected var screenHeight = 10f

        @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_animation)

                calendar = findViewById(R.id.calendar)
                frameLayout = findViewById(R.id.fragment_animation)
                frameLayout.setOnClickListener { onStartAnimation() }
                   onStartAnimation()
           }

        override fun onResume() {
                super.onResume()

                val displayMetrics = DisplayMetrics()
                windowManager.defaultDisplay.getMetrics(displayMetrics)
                screenHeight = displayMetrics.heightPixels.toFloat()
            }

        private fun onStartAnimation() {

                val valueAnimator = ValueAnimator.ofFloat(50f, -screenHeight)

                valueAnimator.addUpdateListener {
                        val value = it.animatedValue as Float
                        calendar.translationY = value
                    }

                valueAnimator.interpolator = LinearInterpolator() as TimeInterpolator?
                valueAnimator.duration = Companion.DEFAULT_ANIMATION_DURATION

                valueAnimator.start()
            }

        companion object {
                val DEFAULT_ANIMATION_DURATION = 2000L
    }
}