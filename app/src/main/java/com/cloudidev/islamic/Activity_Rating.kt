package com.cloudidev.islamic


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatRatingBar

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Activity_Rating : AppCompatActivity() {

    private var getRating: TextView? = null
    private var Submit: Button? = null
    private var RatingBar: AppCompatRatingBar? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)
        getRating = findViewById(R.id.rate)
        Submit = findViewById(R.id.submit)
        RatingBar = findViewById(R.id.penilaian)


        RatingBar?.onRatingBarChangeListener = android.widget.RatingBar.OnRatingBarChangeListener {
                ratingBar, nilai, b -> getRating!!.text = "Rating: $nilai" }

        Submit?.setOnClickListener {
            Toast.makeText(applicationContext, "Nilai Yang Anda Kirimkan: " + RatingBar!!.rating, Toast.LENGTH_SHORT).show() }
    }
}