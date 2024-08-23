package com.goTellCo.ahl

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.window.SplashScreen
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.goTellCo.ahl.screens.main.MainScreen

class MainActivity : AppCompatActivity() {

    private lateinit var splashScreen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        splashScreen = findViewById(R.id.splashScreen)

        Glide.with(this)
            .asGif()
            .load(R.drawable.splash_screen)
            .into(splashScreen)


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,MainScreen::class.java)
            startActivity(intent)
        },2500)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}