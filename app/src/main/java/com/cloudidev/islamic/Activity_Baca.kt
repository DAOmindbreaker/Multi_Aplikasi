package com.cloudidev.islamic

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudidev.islamic.Modules.Database.DatabaseHelper
import com.cloudidev.islamic.Modules.ImportFromFile.Literation
import com.cloudidev.islamic.Modules.ImportFromFile.LiterationInteractor

class Activity_Baca : AppCompatActivity(), Literation {
    /**
     * Created by Rdika19 19/08/2019 "Team Liquid/Dota2"|CloudiDev
     */

    val interactor = LiterationInteractor(this, this)
    val databaseHelper = DatabaseHelper(this)

    override fun successInputDatabase() {
        openNextActivity()
    }

    override fun failedInputDatabase() {
        databaseHelper.clearTable()
        interactor.setData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baca)

        if (databaseHelper.isDataAvailable()){
            openNextActivity()
        }else{
            databaseHelper.clearTable()
            interactor.setData()
        }
    }

    fun openNextActivity(){
        val intent = Intent(this, ListSurahActivity::class.java)
        startActivity(intent)
        finish()
    }
}

