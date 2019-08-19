package com.cloudidev.islamic.Modules.Database

import com.cloudidev.islamic.Entities.Models.Quran

class DatabaseInteractor (var db: DatabaseHelper): DatabaseInput {

    /**
     * Created by Rdika19 13/08/2019 "Team Liquid/Dota2"|CloudiDev
     */

    lateinit var output: DatabaseOutput

    override fun getAllData() {

    }

    override fun updateData(data: Quran) {
//        db.insertData(data)
    }

    override fun getDataById(id: Int) {

    }

    override fun getDataBySurahId(id: Int) {
        val list = db.getDataBySurahId(id)
    }
}