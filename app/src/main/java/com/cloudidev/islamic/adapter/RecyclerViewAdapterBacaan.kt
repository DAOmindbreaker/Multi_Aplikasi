package com.cloudidev.islamic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.cloudidev.islamic.Activity_AsmaulHusna
import com.cloudidev.islamic.R
import com.codesgood.views.JustifiedTextView

class RecyclerViewAdapterBacaan(internal var context1: Context, internal var values: List<Activity_AsmaulHusna.User2>) : RecyclerView.Adapter<RecyclerViewAdapterBacaan.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.costum_layout_bacaan, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bacaan.text = values[position].bacaan
        holder.arti.text = values[position].arti
        holder.bacaan_latin.text = values[position].bacaanLatin
    }

    override fun getItemCount(): Int {
        return values.size
    }

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        internal var bacaan: TextView
        internal var arti: JustifiedTextView
        internal var bacaan_latin: JustifiedTextView
        internal var cardView: CardView

        init {
            bacaan = itemView.findViewById<View>(R.id.tv_bacaan) as TextView
            arti = itemView.findViewById<View>(R.id.tv_arti) as JustifiedTextView
            bacaan_latin = itemView.findViewById<View>(R.id.tv_bacaan_latin) as JustifiedTextView
            cardView = itemView.findViewById<View>(R.id.card_view) as CardView
        }

        override fun onClick(view: View) {

        }
    }
}