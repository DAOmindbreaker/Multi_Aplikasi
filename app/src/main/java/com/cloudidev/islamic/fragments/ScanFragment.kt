package com.cloudidev.islamic.fragments

import android.app.Activity
import android.content.Context
import android.media.RingtoneManager
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.cloudidev.islamic.R

import java.util.ArrayList

import me.dm7.barcodescanner.zbar.BarcodeFormat
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView

class ScanFragment : Fragment(), ZBarScannerView.ResultHandler, MessageDialogFragment.MessageDialogListener {

    private var mActivity: Activity? = null
    private val mContext: Context? = null
    private var zBarScannerView: ZBarScannerView? = null
    private var mFlash: Boolean = false
    private var mAutoFocus: Boolean = false
    private var mSelectedIndices: ArrayList<Int>? = null
    private var mCameraId = -1
    private var contentFrame: ViewGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity
        zBarScannerView = ZBarScannerView(mActivity)
        setupFormats()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_scan, container, false)
        contentFrame = view.findViewById(R.id.content_frame)
        zBarScannerView = ZBarScannerView(mActivity)
        if (savedInstanceState != null) {
            mFlash = savedInstanceState.getBoolean(FLASH_STATE, false)
            mAutoFocus = savedInstanceState.getBoolean(AUTO_FOCUS_STATE, true)
            mSelectedIndices = savedInstanceState.getIntegerArrayList(SELECTED_FORMATS)
            mCameraId = savedInstanceState.getInt(CAMERA_ID, -1)
        } else {
            mFlash = false
            mAutoFocus = true
            mSelectedIndices = null
            mCameraId = -1
        }
        setupFormats()
        contentFrame!!.addView(zBarScannerView)
        return view
    }

    override fun onResume() {
        super.onResume()
        zBarScannerView!!.setResultHandler(this) // Register ourselves as a handler for scan results.
        zBarScannerView!!.startCamera(mCameraId)          // Start camera on resume
        zBarScannerView!!.flash = mFlash
        zBarScannerView!!.setAutoFocus(mAutoFocus)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(FLASH_STATE, mFlash)
        outState.putBoolean(AUTO_FOCUS_STATE, mAutoFocus)
        outState.putIntegerArrayList(SELECTED_FORMATS, mSelectedIndices)
        outState.putInt(CAMERA_ID, mCameraId)
    }

    override fun onPause() {
        super.onPause()
        zBarScannerView!!.stopCamera() // Stop camera on stop
        closeMessageDialog()
    }

    fun setupFormats() {
        val formats = ArrayList<BarcodeFormat>()
        if (mSelectedIndices == null || mSelectedIndices!!.isEmpty()) {
            mSelectedIndices = ArrayList()
            for (i in BarcodeFormat.ALL_FORMATS.indices) {
                mSelectedIndices!!.add(i)
            }
        }

        for (index in mSelectedIndices!!) {
            formats.add(BarcodeFormat.ALL_FORMATS[index])
        }
        if (zBarScannerView != null) {
            zBarScannerView!!.setFormats(formats)
        }
    }

    override fun handleResult(rawResult: Result) {
        try {
            val notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val r = RingtoneManager.getRingtone(activity!!.applicationContext, notification)
            r.play()
        } catch (e: Exception) {
        }

        showMessageDialog(rawResult.contents)
    }

    fun showMessageDialog(message: String) {
        val fragment = MessageDialogFragment.newInstance("Scan Results", message, this)
        fragment.show(activity!!.supportFragmentManager, "scan_results")
    }

    fun closeMessageDialog() {
        closeDialog("scan_results")
    }

    fun closeDialog(dialogName: String) {
        val fragmentManager = activity!!.supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(dialogName) as DialogFragment?
        fragment?.dismiss()
    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        // Resume the camera
        zBarScannerView!!.resumeCameraPreview(this)
    }

    companion object {
        private val FLASH_STATE = "FLASH_STATE"
        private val AUTO_FOCUS_STATE = "AUTO_FOCUS_STATE"
        private val SELECTED_FORMATS = "SELECTED_FORMATS"
        private val CAMERA_ID = "CAMERA_ID"
    }
}
