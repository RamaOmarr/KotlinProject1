package com.example.greenvalleygp2

import android.app.Service
import android.content.Intent
import android.os.CountDownTimer
import android.os.IBinder
import java.util.*


class MyService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        object : CountDownTimer(5000, 1000) {
            override fun onFinish() {
                val startActivity = Intent(this@MyService, LoginPage::class.java)
                startActivity(startActivity)
                //finish()
            }

            override fun onTick(millisUntilFinished: Long) {}
        }.start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}