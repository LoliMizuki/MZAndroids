package com.lolimizuki.mz

import android.icu.text.NumberFormat
import java.text.DecimalFormat
import java.util.Locale

object NumbersHelp {

    @JvmStatic
    fun doubleFromString(string: String): Double? {
        return try {
            NumberFormat
                .getInstance(Locale.getDefault())
                .parse(string)
                .toDouble()

        } catch (_: Exception) {
            null
        }
    }

    @JvmStatic
    fun doubleFromString(string: String, defaule: Double): Double {
        return doubleFromString(string) ?: defaule
    }

    @JvmStatic
    fun decimalSeparator(): String {
        return (DecimalFormat.getInstance(Locale.getDefault()) as DecimalFormat)
            .decimalFormatSymbols
            .decimalSeparator
            .toString()
    }

    @JvmStatic
    fun notAllowDecimalSeparator(): String {
        val current = decimalSeparator()
        return if (current == ".") "," else "."
    }
}