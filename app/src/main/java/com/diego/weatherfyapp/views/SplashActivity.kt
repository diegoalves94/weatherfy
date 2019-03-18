package com.diego.weatherfyapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.diego.weatherfyapp.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        open()
    }


    /*
    * Runs lottie animation and goes to MainActivity.
    * */
    private fun open() {
        anim_loading.playAnimation()

        Handler().postDelayed({
            finishAffinity()
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }, 2500)
    }

}
