package com.lutech.baseproject.ads.welcome

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lutech.baseproject.R
import com.lutech.baseproject.ads.AppOpenManager
import com.lutech.baseproject.ads.MyApplication

class WelcomeBackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_back)
        Log.d("=====>TAGGGGGG", "onCreate12345: ")
        try {
            MyApplication.appOpenManager?.setOpenAdsListener(object :
                AppOpenManager.OpenAdsListener {
                override fun dismissAds() {
                    finish()
                }

                override fun dismissTimer() {

                }
            })
            Handler(Looper.getMainLooper()).postDelayed({
                MyApplication.appOpenManager?.showAdIfAvailable()
            }, 2500)

        } catch (e: Exception) {
            finish()
        }
    }

    override fun onBackPressed() {

    }
}