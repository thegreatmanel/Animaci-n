package com.example.propa.kotlinanim20

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)

start_button.setOnClickListener{
        val salto = Intent(this, AnimationActivity::class.java)
        salto.putExtra("key1", "valor1")
        startActivity(salto)
    }}
}
