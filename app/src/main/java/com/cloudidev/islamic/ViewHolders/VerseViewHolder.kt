package com.cloudidev.islamic.ViewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cloudidev.islamic.Entities.Models.Quran
import kotlinx.android.synthetic.main.list_verse.view.*

class VerseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    /**
     * Created by Rdika19 13/08/2019 "Team Liquid/Dota2"|CloudiDev
     */


    fun onBind(model: Quran) = with(itemView){

        val number = "${model.verseId}".replace("1", "١").replace("0", "٠")
                .replace("2", "٢").replace("3", "٣").replace("4", "٤")
                .replace("5","٥" ).replace("6", "٦").replace("7", "٧")
                .replace("9", "٩").replace("8", "٨")
        text_verse_id.text = "-$number-"
        text_original.text = model.ayahText
        text_translate.text = model.translation.replace("\\\"", "\"")

    }
}