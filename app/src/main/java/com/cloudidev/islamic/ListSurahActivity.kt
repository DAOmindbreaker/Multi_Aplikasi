package com.cloudidev.islamic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudidev.islamic.Entities.List.Surah
import com.cloudidev.islamic.Entities.Models.SurahModel
import com.cloudidev.islamic.Support.Utils.Adapter
import com.cloudidev.islamic.ViewHolders.SurahViewHolder
import kotlinx.android.synthetic.main.activity_list_surah.*

/**
 * Created by Rdika19 13/08/2019 "Team Liquid/Dota2"|CloudiDev
 */

class ListSurahActivity: AppCompatActivity(){


    lateinit var  adapter : Adapter<SurahModel, SurahViewHolder>
    val surah = Surah()
    val listSurah: ArrayList<SurahModel>
        get() = surah.surahList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_surah)
        setToolbar()
        setList()
    }

    private fun setToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    private fun setList(){
        val manager = LinearLayoutManager(this)
        adapter = object : Adapter<SurahModel, SurahViewHolder>(R.layout.list_surah, SurahViewHolder::class.java,
                SurahModel::class.java, listSurah){
            override fun bindView(holder: SurahViewHolder, tipeData: SurahModel, position: Int) {
                holder.onBind(applicationContext, tipeData)
            }
        }

        list_surah.layoutManager = manager
        list_surah.adapter = adapter


    }

}