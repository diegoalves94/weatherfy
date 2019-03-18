package com.diego.weatherfyapp.extras

import android.app.Activity
import android.app.Dialog
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.diego.weatherfyapp.R
import kotlinx.android.synthetic.main.dialog_exit.*

fun toolbarSettings(activity: AppCompatActivity, title: String, toolbar: Toolbar) {
    activity.setSupportActionBar(toolbar)
    activity.supportActionBar!!.title = title

    toolbar.logo = null
    activity.supportActionBar!!.setHomeButtonEnabled(true)
    activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
}


//DIALOGS
fun Activity.dialogExit(){

    var dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(R.layout.dialog_exit)
    dialog.setCancelable(true)

    val lp = WindowManager.LayoutParams()
    val window = dialog.window
    lp.copyFrom(window.attributes)
    lp.width = WindowManager.LayoutParams.MATCH_PARENT
    lp.height = WindowManager.LayoutParams.WRAP_CONTENT
    window?.attributes = lp

    //CANCEL
    dialog.btnCancel.setOnClickListener {
        dialog.dismiss()
    }

    //EXIT
    dialog.btnExit.setOnClickListener {
        finishAffinity()
        dialog.dismiss()
    }

    dialog.show()
}