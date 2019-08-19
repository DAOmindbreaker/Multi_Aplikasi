package com.cloudidev.islamic

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Rdika19 13/08/2019 "Team Liquid/Dota2"|CloudiDev
 */

internal class HalalAdapter constructor(private val context: Context, private val dataHalal: List<DataHalal>) : RecyclerView.Adapter<HalalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produk_halal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val halal = dataHalal[position]
        holder.nama_produk.text = halal.title
        holder.nama_produsen.text = halal.produsen
        holder.nomor_sertifikat.text = halal.nomor_sertifikat
        holder.berlaku.text = halal.berlaku_hingga

        holder.btn_bagikan.setOnClickListener {
            val s = Intent(Intent.ACTION_SEND)
            s.type = "text/plain"
            val share = Html.fromHtml("Nama Produk : <b>" + halal.title +
                    "</b><br> Nama Produsen : <b>" + halal.produsen +
                    "</b><br> Nomor Sertifikat : <b>" + halal.nomor_sertifikat +
                    "</b><br> Berlaku : <b><i>" + halal.berlaku_hingga + "</i></b>").toString()
            s.putExtra(Intent.EXTRA_TEXT, share)
            context.startActivity(s)
        }
        //Toast.makeText(context, halal.toString(),Toast.LENGTH_LONG).show();

    }

    override fun getItemCount(): Int {
        return dataHalal.size
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nama_produk: TextView
        var nama_produsen: TextView
        var nomor_sertifikat: TextView
        var berlaku: TextView
        var btn_bagikan: Button

        init {
            nama_produk = itemView.findViewById(R.id.tv_nama_produk)
            nama_produsen = itemView.findViewById(R.id.tv_nama_produsen)
            nomor_sertifikat = itemView.findViewById(R.id.tv_nomor_sertifikat)
            berlaku = itemView.findViewById(R.id.tv_berlaku)
            btn_bagikan = itemView.findViewById(R.id.btn_bagikan)
        }
    }
}