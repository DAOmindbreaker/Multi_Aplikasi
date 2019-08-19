package com.cloudidev.islamic.Modules.Database

import com.cloudidev.islamic.Entities.Models.Quran

/**
 * Created by Rdika19 13/08/2019 "Team Liquid/Dota2"|CloudiDev
 */

interface DatabaseInput{
    fun getAllData()
    fun updateData(data: Quran)
    fun getDataById(id: Int)
    fun getDataBySurahId(id: Int)
}

interface DatabaseOutput{
    fun successGetAllData(list: List<Quran>)
    fun successUpdateData()
    fun successGetDataById(data: Quran)
    fun successGetDataBySurahId(list: List<Quran>)
}

interface DatabaseInterface{
    fun getAllData()
    fun updateData(data: Quran)
    fun getDataById(id: Int)
    fun getDataBySurahId(id: Int)
}

interface DatabaseView{
    fun successGetDataBySurahId(list: List<Quran>)

}
