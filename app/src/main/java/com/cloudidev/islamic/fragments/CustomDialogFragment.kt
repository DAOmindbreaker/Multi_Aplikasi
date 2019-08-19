package com.cloudidev.islamic.fragments

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView

import com.cloudidev.islamic.R

class CustomDialogFragment : DialogFragment() {

    private var mActionOk: TextView? = null
    private var mActionCancel: TextView? = null
    private var editTextNewContent: EditText? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_custom_dialog, container, false)

        mActionCancel = view.findViewById(R.id.action_cancel)
        mActionOk = view.findViewById(R.id.action_ok)
        editTextNewContent = view.findViewById(R.id.editTextNewContent)

        if (arguments != null) {
            if (arguments!!.containsKey("content")) {
                editTextNewContent!!.setText(arguments!!.getString("content"))
            }
        }

        mActionCancel!!.setOnClickListener { dialog?.dismiss() }

        mActionOk!!.setOnClickListener { dialog?.dismiss() }

        return view
    }
}
