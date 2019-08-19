package com.cloudidev.islamic.Modules.Database

import com.cloudidev.islamic.Entities.Models.Quran

/**
 * Created by Rdika19 13/08/2019 "Team Liquid/Dota2"|CloudiDev
 */

class DatabasePresenter (var interactor: DatabaseHelper,
                         var view: DatabaseView): DatabaseInterface, DatabaseOutput {

    init {
        interactor.output = this
    }

    override fun successGetAllData(list: List<Quran>) {
    }

    override fun successUpdateData() {
    }

    override fun successGetDataById(data: Quran) {
    }

    override fun successGetDataBySurahId(list: List<Quran>) {
        view.successGetDataBySurahId(list)
    }

    override fun getAllData() {
    }

    override fun updateData(data: Quran) {
//        interactor.updateData(data)
    }

    override fun getDataById(id: Int) {
    }

    override fun getDataBySurahId(id: Int) {
        interactor.getDataBySurahId(id)
    }
}