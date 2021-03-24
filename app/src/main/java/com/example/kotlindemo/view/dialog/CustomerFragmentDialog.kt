package com.example.kotlindemo.view.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.example.kotlindemo.R
import java.lang.IllegalStateException
import java.util.stream.DoubleStream.builder

class CustomerFragmentDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder =AlertDialog.Builder(it)
            //自定义dialog
            val  inflater=requireActivity().layoutInflater
            builder.setView(inflater.inflate(R.layout.dialog_item,null))
            builder.create()
        }?:throw IllegalStateException("Activity cannot be  null")
    }
}