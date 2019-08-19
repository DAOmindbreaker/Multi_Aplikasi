package com.cloudidev.islamic.fragments

import android.app.Activity
import android.graphics.Bitmap
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

import android.graphics.Color.BLACK
import android.graphics.Color.WHITE

class GenerateQRcodeFragment : Fragment() {

    private var mInputText: EditText? = null
    private var mImageView: ImageView? = null
    private var mSave: FloatingActionButton? = null
    private var mActivity: Activity? = null
    private var generatedBitmap: Bitmap? = null
    private var fileName: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_generate_qrcode, container, false)

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
                    try {
                        generateQRcode(charSequence.toString())
                    } catch (e: WriterException) {
                        e.printStackTrace()
                    }

                }
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })

        mSave!!.setOnClickListener { saveImage(generatedBitmap) }

        return view
    }

    @Throws(WriterException::class)
    private fun generateQRcode(s: String) {
        fileName = s
        val result: BitMatrix
        result = MultiFormatWriter().encode(s, BarcodeFormat.QR_CODE, 1080, 1080, null)
        val w = result.width
        val h = result.height
        val pixels = IntArray(w * h)
        for (y in 0 until h) {
            val offset = y * w
            for (x in 0 until w) {
                pixels[offset + x] = if (result.get(x, y)) BLACK else WHITE
            }
        }
        val bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        bitmap.setPixels(pixels, 0, 1080, 0, 0, w, h)
        generatedBitmap = bitmap
        mImageView!!.setImageBitmap(bitmap)
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
}
