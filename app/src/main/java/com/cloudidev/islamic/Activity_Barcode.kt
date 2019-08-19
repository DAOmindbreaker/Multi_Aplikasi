package com.cloudidev.islamic


import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.cloudidev.islamic.fragments.GenerateBarcodeFragment
import com.cloudidev.islamic.fragments.GenerateQRcodeFragment
import com.cloudidev.islamic.fragments.ScanFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Activity_Barcode : AppCompatActivity() {

    /**
     * Created by Rdika19 19/08/2019 "Team Liquid/Dota2"|CloudiDev
     */

    private var mBottomNavigationView: BottomNavigationView? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_scan -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.content_frame, ScanFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_generate_barcode -> {
                val transaction2 = supportFragmentManager.beginTransaction()
                transaction2.replace(R.id.content_frame, GenerateBarcodeFragment())
                transaction2.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_generate_qrcode -> {
                val transaction3 = supportFragmentManager.beginTransaction()
                transaction3.replace(R.id.content_frame, GenerateQRcodeFragment())
                transaction3.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barcode)
        checkPermission()

        mBottomNavigationView = findViewById(R.id.bottomNavigationView)
        mBottomNavigationView!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_frame, ScanFragment())
        transaction.commit()
    }

    private fun checkPermission() {
        val PERMISSION_ALL = 1
        val PERMISSIONS = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)

        if (!hasPermissions(this, *PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL)
        }
    }

    companion object {

        fun hasPermissions(context: Context?, vararg permissions: String): Boolean {
            if (context != null && permissions != null) {
                for (permission in permissions) {
                    if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                        return false
                    }
                }
            }
            return true
        }
    }
}
