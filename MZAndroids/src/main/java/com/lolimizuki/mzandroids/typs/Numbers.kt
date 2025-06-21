package com.lolimizuki.mzandroids.typs

import android.icu.text.NumberFormat
import java.text.DecimalFormat
import java.util.Locale

fun Double.Companion.from(string: String): Double? {
    return try {
        NumberFormat
            .getInstance(Locale.getDefault())
            .parse(string)
            .toDouble()

    } catch (_: Exception) {
        null
    }
}

fun Double.Companion.from(string: String, default: Double): Double {
    return try {
        NumberFormat
            .getInstance(Locale.getDefault())
            .parse(string)
            .toDouble()

    } catch (_: Exception) {
        default
    }
}

fun Double.Companion.decimalSeparator(locale: Locale = Locale.getDefault()): String {
    return (DecimalFormat.getInstance(locale) as DecimalFormat)
        .decimalFormatSymbols
        .decimalSeparator
        .toString()
}

fun Double.Companion.notAllowDecimalSeparator(
    locale: Locale = Locale.getDefault()
): String {
    val current = Double.decimalSeparator(locale)
    return if (current == ".") "," else "."
}

object NumbersHelp {

    @JvmStatic
    fun doubleFromString(string: String): Double? {
        return Double.from(string)
    }

    @JvmStatic
    fun doubleFromString(string: String, defaule: Double): Double {
        return Double.from(string, defaule)
    }

    @JvmStatic
    fun decimalSeparator(): String {
        return Double.decimalSeparator()
    }

    @JvmStatic
    fun notAllowDecimalSeparator(): String {
        return Double.notAllowDecimalSeparator()
    }
}