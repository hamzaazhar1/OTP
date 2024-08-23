package com.goTellCo.ahl.screens.otp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.goTellCo.ahl.R
import com.goTellCo.ahl.screens.home.HomeActivity
import com.otpview.OTPTextView

class OTPActivity : AppCompatActivity() {

    private val otp = "1234"

    private lateinit var otpTextView: OTPTextView
    private lateinit var btValidate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_otpactivity)

        otpTextView = findViewById(R.id.otp_view)
        btValidate = findViewById(R.id.btValidate)

        btValidate.setOnClickListener {
            val otpEntered = otpTextView.otp

            if (otpEntered!!.length < 4)
                Toast.makeText(this,"Enter Complete OTP",Toast.LENGTH_SHORT).show()
            else
            {
                if(otpEntered == otp)
                    startActivity(Intent(this,HomeActivity::class.java))
                else
                    Toast.makeText(this,"Invalid OTP",Toast.LENGTH_SHORT).show()

            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}