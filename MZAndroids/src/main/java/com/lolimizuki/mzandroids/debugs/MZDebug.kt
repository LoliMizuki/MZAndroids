package com.lolimizuki.mzandroids.debugs

import android.util.Log

object MZDebug {

    @JvmStatic
    var isEnable: Boolean = false

    @JvmStatic
    fun log(message: String, logType: LogType = LogType.default) {
        if (!isEnable) { return }

        val caller = Exception().stackTrace.getOrNull(2) ?: return

        val fileName = caller.fileName.substringBeforeLast(".")
        val className = caller.className.substringAfterLast(".")
        val functionName = caller.methodName
        val lineNumber = caller.lineNumber

        val tag = fileName
        val location = "${className}.${functionName}()(l:${lineNumber})"

        _logSelector(tag, "${location}: ${message}")
    }

    @JvmStatic
    fun logFunctionName(prefix: String = "", logType: LogType = LogType.default) {
        if (!isEnable) { return }

        val caller = Exception().stackTrace.getOrNull(2) ?: return

        val fileName = caller.fileName.substringBeforeLast(".")
        val className = caller.className.substringAfterLast(".")
        val functionName = caller.methodName
        val lineNumber = caller.lineNumber

        val tag = fileName
        val prefix = if (!prefix.isEmpty()) "${prefix} " else ""
        val location = "${className}.${functionName}()(l:${lineNumber})"

        _logSelector(tag, "${prefix}${location}")
    }

    private fun _logSelector(
        tag: String,
        message: String,
        logType: LogType = LogType.debug
    ) {
        when (logType) {
            LogType.verbose -> Log.v(tag, message)
            LogType.debug -> Log.d(tag, message)
            LogType.info -> Log.i(tag, message)
            LogType.warn -> Log.w(tag, message)
            LogType.error -> Log.e(tag, message)
        }
    }
}

enum class LogType {
    verbose, debug, info, warn, error;

    companion object {
        val default: LogType = LogType.verbose
    }
}
