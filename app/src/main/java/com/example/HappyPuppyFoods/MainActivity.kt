package com.example.HappyPuppyFoods

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.racipeapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper())
            .postDelayed(
                {
                    startActivity(Intent(this,HomeActivity::class.java))
                    finish()
                },2000
            )
    }
}