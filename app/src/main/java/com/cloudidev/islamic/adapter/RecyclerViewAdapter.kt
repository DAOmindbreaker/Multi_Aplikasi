package com.cloudidev.islamic.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

import com.cloudidev.islamic.ActivityAsmaulHusnaDetail
import com.cloudidev.islamic.Activity_AsmaulHusna
import com.cloudidev.islamic.R


class RecyclerViewAdapter(internal var context1: Context, internal var values: List<Activity_AsmaulHusna.User>) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.costum_layout_asmaul_husna, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.no.text = values[position].no
        holder.ayat.text = values[position].ayat
        holder.bacaan.text = values[position].bacaan
        holder.arti.text = values[position].arti

        holder.cardView.setOnClickListener { view ->
            val myIntent = Intent(context1, ActivityAsmaulHusnaDetail::class.java)
            myIntent.putExtra("position", position)
            myIntent.putExtra("ayat", values[position].ayat)
            myIntent.putExtra("bacaan", values[position].bacaan)
            myIntent.putExtra("arti", values[position].arti)
            view.context.startActivity(myIntent)
        }
    }

    override fun getItemCount(): Int {
        return values.size
    }

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        internal var ayat: TextView
        internal var bacaan: TextView
        internal var arti: TextView
        internal var no: TextView
        internal var cardView: CardView
        internal var linearLayout: LinearLayout

        init {
            ayat = itemView.findViewById<View>(R.id.tv_ayat) as TextView
            bacaan = itemView.findViewById<View>(R.id.tv_bacaan) as TextView
            arti = itemView.findViewById<View>(R.id.tv_arti) as TextView
            no = itemView.findViewById<View>(R.id.tv_no) as TextView
            cardView = itemView.findViewById<View>(R.id.card_view) as CardView
            linearLayout = itemView.findViewById<View>(R.id.tes) as LinearLayout
        }

        override fun onClick(view: View) {

        }
    }
}