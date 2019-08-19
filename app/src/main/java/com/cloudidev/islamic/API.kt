package com.cloudidev.islamic

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by Rdika19 13/08/2019 "Team Liquid/Dota2"|CloudiDev
 */

object API {

    val BASE_URL = "https://sites.google.com/"
    val KEY = "macros/exec?service=AKfycbx_-gZbLP7Z2gGxehXhWMWDAAQsTp3e3bmpTBiaLuzSDQSbIFWD"
    val MENU = "&menu="
    val KUERI = "&query="
    val NAMA_PRODUK = "nama_produk"
    val NAMA_PRODUSEN = "nama_produsen"
    val NOMOR_SERTIFIKAT = "nomor_sertifikat"

    var postService: PostService? = null

    val service: PostService?
        get() {
            if (postService == null) {
                val retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                postService = retrofit.create(PostService::class.java)
            }
            return postService
        }

    interface PostService {
        @GET
        fun getProdukList(@Url url: String): Call<ProdukHalal>
    }

}