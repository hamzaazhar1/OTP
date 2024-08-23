package com.goTellCo.ahl.screens.main

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.goTellCo.ahl.R
import com.goTellCo.ahl.screens.otp.OTPActivity
import com.google.android.material.textfield.TextInputEditText

class MainScreen : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var etPhoneNumber: TextInputEditText
    private lateinit var btProceed: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)

        spinner = findViewById(R.id.countryCodeSpinner)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)

        ArrayAdapter.createFromResource(
            this,
                    R.array.country_codes,
                    android.R.layout.simple_spinner_item
            ).also { arrayAdapter ->

                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = arrayAdapter
        }


        val defaultPosition = resources.getStringArray(R.array.country_codes).indexOf("+92 Pakistan")

        if (defaultPosition != -1)
            spinner.setSelection(defaultPosition)



        btProceed = findViewById(R.id.btProceed)

        btProceed.setOnClickListener {
            if (etPhoneNumber.text!!.length == 11)
                startActivity(Intent(this,OTPActivity::class.java))
            else
                Toast.makeText(this,"Enter a number",Toast.LENGTH_SHORT).show()

        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}