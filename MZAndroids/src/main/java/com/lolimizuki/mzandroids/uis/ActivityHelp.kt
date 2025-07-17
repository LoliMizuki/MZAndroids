package com.lolimizuki.mzandroids.uis

import android.os.Build
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity
import kotlin.Boolean


fun AppCompatActivity.fixTopBottomBarsForSuck35Above(
    isPaddingTop: Boolean,
    isPaddingBottom: Boolean,
) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.UPSIDE_DOWN_CAKE) return

    window.decorView.setOnApplyWindowInsetsListener { view, insets ->
        val topPadding =
            insets.getInsets(WindowInsets.Type.statusBars()).top
        val bottomPadding =
            insets.getInsets(WindowInsets.Type.navigationBars()).bottom

        view.setPadding(
            0,
            if (isPaddingTop) topPadding else 0,
            0,
            if (isPaddingBottom) bottomPadding else 0
        )

        insets
    }
}

object ActivityHelp {

    @JvmStatic
    fun fixTopBottomBarsForSuck35To(activity: AppCompatActivity) {
        activity.fixTopBottomBarsForSuck35Above(
            isPaddingTop = true,
            isPaddingBottom = true
        )
    }
}

