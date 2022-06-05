package com.example.greenvalleygp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FirstPic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_pic)

        startService(Intent(this, MyService::class.java))
    }
}