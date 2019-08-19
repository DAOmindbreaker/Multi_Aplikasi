package com.cloudidev.islamic

import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.cloudidev.islamic.*

class Activity_Main : AppCompatActivity() {

    /**
     * Created by Rdika19 13/08/2019 "Team Liquid/Dota2"|CloudiDev
     */

    internal lateinit var rellay_jadwal: RelativeLayout //rellay_jadwal
    internal lateinit var rellay_baca: RelativeLayout //rellay_baca
    internal lateinit var rellay_halal: RelativeLayout //rellay_halal
    internal lateinit var rellay_asmaulhusna: RelativeLayout // rellay_hadist
    internal lateinit var rellay_kajian: RelativeLayout // rellay_gallery
    internal lateinit var rellay_map: RelativeLayout // rellay_map
    internal lateinit var rellay_barcode: RelativeLayout // rellay_weather
    internal lateinit var rellay_rating: RelativeLayout // rellay_setting

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rellay_jadwal = findViewById(R.id.rellay_jadwal)
        rellay_baca = findViewById(R.id.rellay_baca)
        rellay_halal = findViewById(R.id.rellay_halal)
        rellay_asmaulhusna = findViewById(R.id.rellay_asmaulhusna)
        rellay_kajian = findViewById(R.id.rellay_kajian)
        rellay_map = findViewById(R.id.rellay_map)
        rellay_barcode = findViewById(R.id.rellay_barcode)
        rellay_rating = findViewById(R.id.rellay_rating)

        rellay_jadwal.setOnClickListener {
            val intent = Intent(this@Activity_Main, Activity_Jadwal::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }

        rellay_baca.setOnClickListener {
            val intent = Intent(this@Activity_Main, Activity_Baca::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
        rellay_halal.setOnClickListener {
            val intent = Intent(this@Activity_Main, Activity_Halal::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
        rellay_asmaulhusna.setOnClickListener {
            val intent = Intent(this@Activity_Main, Activity_AsmaulHusna::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
        rellay_kajian.setOnClickListener {
            val intent = Intent(this@Activity_Main, Activity_Kajian::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
        rellay_map.setOnClickListener {
            val intent = Intent(this@Activity_Main, Activity_Map::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
        rellay_barcode.setOnClickListener {
            val intent = Intent(this@Activity_Main, Activity_Barcode::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
        rellay_rating.setOnClickListener {
            val intent = Intent(this@Activity_Main, Activity_Rating::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
    }
}
