package com.cloudidev.islamic.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MessageDialogFragment : DialogFragment() {

    private var mTitle: String? = null
    private var mMessage: String? = null
    private var mListener: MessageDialogListener? = null

    interface MessageDialogListener {
        fun onDialogPositiveClick(dialog: DialogFragment)
    }

    override fun onCreate(state: Bundle?) {
        super.onCreate(state)
        retainInstance = true
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage(mMessage)
                .setTitle(mTitle)

        builder.setPositiveButton("OK") { dialog, id ->
            if (mListener != null) {
                mListener!!.onDialogPositiveClick(this@MessageDialogFragment)
            }
        }

        return builder.create()
    }

    companion object {

        fun newInstance(title: String, message: String, listener: MessageDialogListener): MessageDialogFragment {
            val fragment = MessageDialogFragment()
            fragment.mTitle = title
            fragment.mMessage = message
            fragment.mListener = listener
            return fragment
        }
    }
}