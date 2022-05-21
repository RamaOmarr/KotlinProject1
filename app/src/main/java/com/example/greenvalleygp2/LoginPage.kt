package com.example.greenvalleygp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        var CreatFarmAcc : TextView= findViewById(R.id.CreateAcc)
        val LoginButton : Button = findViewById(R.id.LoginBtn)

        LoginButton.setOnClickListener{
            val HomeIntent= Intent(this, MainActivity::class.java)
            startActivity(HomeIntent)
        }

        CreatFarmAcc.setOnClickListener{
            val SignupIntent= Intent(this, FarmOwnerSignup::class.java)
            startActivity(SignupIntent)
        }
    }
}