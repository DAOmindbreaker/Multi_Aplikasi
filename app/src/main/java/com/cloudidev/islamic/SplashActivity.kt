package com.cloudidev.islamic

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager

import androidx.appcompat.app.AppCompatActivity

import com.facebook.shimmer.ShimmerFrameLayout

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val thread = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(3000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    startActivity(Intent(this@SplashActivity, Activity_Main::class.java))
                    finish()
                }
            }
        }
        thread.start()
    }
}
