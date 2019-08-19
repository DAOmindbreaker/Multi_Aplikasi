package com.cloudidev.islamic.fragments

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.fragment.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

import com.cloudidev.islamic.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix

import java.io.File
import java.io.FileOutputStream
import java.util.Arrays

class GenerateBarcodeFragment : Fragment() {

    private var mInputText: EditText? = null
    private var mImageView: ImageView? = null
    private var mSave: FloatingActionButton? = null
    private var mActivity: Activity? = null
    private var generatedBitmap: Bitmap? = null
    private var fileName: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_generate_barcode, container, false)
        mActivity = activity

        mInputText = view.findViewById(R.id.inputText)
        mImageView = view.findViewById(R.id.outputBitmap)
        mSave = view.findViewById(R.id.save)


        mInputText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length == 0) {
                    mImageView!!.setImageResource(R.drawable.ic_placeholder)
                } else {
                    generateBarcode(charSequence.toString())
                }
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })

        mSave!!.setOnClickListener { saveImage(generatedBitmap) }

        return view
    }

    private fun saveImage(generatedBitmap: Bitmap?) {
        var out: FileOutputStream? = null
        val file = File(Environment.getExternalStorageDirectory().path, "QRCodeBarcode")
        if (!file.exists()) {
            file.mkdirs()
        }
        if (fileName!!.contains("/")) {
            fileName = fileName!!.replace("/", "\\")
        }
        val filePath = file.absolutePath + "/" + fileName + ".png"
        try {
            out = FileOutputStream(filePath)
            generatedBitmap!!.compress(Bitmap.CompressFormat.PNG, 100, out)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        Toast.makeText(mActivity, "File saved at\n$filePath", Toast.LENGTH_SHORT).show()
    }

    private fun generateBarcode(s: String) {
        fileName = s
        val writer = MultiFormatWriter()
        val finalData = Uri.encode(s)

        // Use 1 as the height of the matrix as this is a 1D Barcode.
        var bm: BitMatrix? = null
        try {
            bm = writer.encode(finalData, BarcodeFormat.CODE_128, 1080, 1)
        } catch (e: WriterException) {
            e.printStackTrace()
        }

        val bmWidth = bm!!.width

        val imageBitmap = Bitmap.createBitmap(bmWidth, 640, Bitmap.Config.ARGB_8888)

        for (i in 0 until bmWidth) {
            // Paint columns of width 1
            val column = IntArray(640)
            Arrays.fill(column, if (bm.get(i, 0)) Color.BLACK else Color.WHITE)
            imageBitmap.setPixels(column, 0, 1, i, 0, 1, 640)
        }

        generatedBitmap = imageBitmap

        mImageView!!.setImageBitmap(imageBitmap)
    }
}
