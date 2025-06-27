package com.lolimizuki

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.lolimizuki.mz.R
import com.lolimizuki.mzandroids.debugs.MZDebug

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_activity)

        MZDebug.isEnable = true
    }
}