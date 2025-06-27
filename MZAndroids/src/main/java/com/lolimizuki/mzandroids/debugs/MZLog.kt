package com.lolimizuki.mzandroids.debugs

import android.util.Log

object MZDebug {

    @JvmStatic
    var isEnable: Boolean = false

    @JvmStatic
    fun log(message: String, logType: LogType = LogType.default) {
        if (!isEnable) { return }

        val trace = Exception().stackTrace
//        trace.

//        log
//        Log.d("xxxTAG", "log: ${trace}")
        print(trace)
    }
}

enum class LogType {
    default,
    debug
}