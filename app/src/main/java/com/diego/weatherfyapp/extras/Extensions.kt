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
