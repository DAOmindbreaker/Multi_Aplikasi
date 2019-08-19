package com.cloudidev.islamic

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class Activity_Halal : AppCompatActivity() {
    /**
     * Created by Rdika19 19/08/2019 "Team Liquid/Dota2"|CloudiDev
     */

    private var keyword: EditText? = null
    private var btn_cari: ImageView? = null

    private val data = ArrayList<DataHalal>()

    private var progressBar: ProgressBar? = null
    private var halal_list: RecyclerView? = null
    private var manager: LinearLayoutManager? = null
    private var halalAdapter: HalalAdapter? = null

    private var tidak_ada: ConstraintLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halal)

        keyword = findViewById(R.id.input_keyword)
        btn_cari = findViewById(R.id.btn_cari)
        progressBar = findViewById(R.id.progressBar)
        halal_list = findViewById(R.id.list_halal)
        tidak_ada = findViewById(R.id.tidak_ada_data)

        btn_cari!!.setOnClickListener {
            if (!TextUtils.isEmpty(keyword!!.text)) {

                tidak_ada!!.visibility = View.GONE
                progressBar!!.visibility = View.VISIBLE
                manager!!.scrollToPositionWithOffset(0, 0)
                data.clear()
                dapatkanData()

            } else {
                Toast.makeText(this@Activity_Halal, "Masukkan nama barang, nama produsen atau nomor sertifikat.",
                        Toast.LENGTH_LONG).show()
            }
        }

        manager = LinearLayoutManager(this)
        halalAdapter = HalalAdapter(this, data)
        halal_list!!.layoutManager = manager
        halal_list!!.adapter = halalAdapter

    }

    private fun dapatkanData() {

        val url_satu = API.BASE_URL + API.KEY + API.MENU + API.NAMA_PRODUK + API.KUERI + keyword!!.text
        val url_dua = API.BASE_URL + API.KEY + API.MENU + API.NAMA_PRODUSEN + API.KUERI + keyword!!.text
        val url_tiga = API.BASE_URL + API.KEY + API.MENU + API.NOMOR_SERTIFIKAT + API.KUERI + keyword!!.text

        val produkHalal = API.service!!.getProdukList(url_satu)

        produkHalal.enqueue(object : Callback<ProdukHalal> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<ProdukHalal>, response: Response<ProdukHalal>) {

                val halal = response.body()

                if (halal!!.status != "error") {
                    data.addAll(halal.data!!)
                    halalAdapter!!.notifyDataSetChanged()
                    progressBar!!.visibility = View.GONE

                    //Toast.makeText(Activity_Main.this,"Hasil: "+ halal.toString(),Toast.LENGTH_LONG).show();
                } else {
                    val produkHalal2 = API.service!!.getProdukList(url_dua)
                    produkHalal2.enqueue(object : Callback<ProdukHalal> {
                        override fun onResponse(call: Call<ProdukHalal>, response: Response<ProdukHalal>) {
                            val halal2 = response.body()
                            if (halal2!!.status != "error") {
                                data.addAll(halal2.data!!)
                                halalAdapter!!.notifyDataSetChanged()
                                progressBar!!.visibility = View.GONE
                            } else {
                                val produkHalal3 = API.service!!.getProdukList(url_tiga)
                                produkHalal3.enqueue(object : Callback<ProdukHalal> {
                                    override fun onResponse(call: Call<ProdukHalal>, response: Response<ProdukHalal>) {

                                        val halal3 = response.body()
                                        if (halal3!!.status != "error") {
                                            data.addAll(halal3.data!!)
                                            halalAdapter!!.notifyDataSetChanged()
                                            progressBar!!.visibility = View.GONE
                                        } else {
                                            progressBar!!.visibility = View.GONE
                                            val error: TextView
                                            val ket: TextView
                                            tidak_ada!!.visibility = View.VISIBLE
                                            error = findViewById(R.id.tv_belum_ada)
                                            ket = findViewById(R.id.tv_keterangan)
                                            error.text = Html.fromHtml("Oppps.. Hasil pencarian untuk <u><i>" + keyword!!.text + "</i></u> tidak ditemukan.")
                                            ket.setText(R.string.keterangan)
                                        }

                                    }

                                    override fun onFailure(call: Call<ProdukHalal>, t: Throwable) {

                                    }
                                })
                            }

                        }

                        override fun onFailure(call: Call<ProdukHalal>, t: Throwable) {

                        }
                    })

                }


            }

            override fun onFailure(call: Call<ProdukHalal>, t: Throwable) {
                progressBar!!.visibility = View.GONE
                Toast.makeText(this@Activity_Halal, "Gagal memuat hasil, perisa koneksi internet anda.", Toast.LENGTH_LONG).show()

            }
        })

    }
}

