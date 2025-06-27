package com.lolimizuki.mzandroids.typs

import android.icu.text.NumberFormat
import java.text.DecimalFormat
import java.util.Locale

// region Float

fun Float.toString(format: String): String {
    return String.format(format, this)
}

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

// endregion


// region Double

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

fun Double.toString(format: String): String {
    return String.format(format, this.toFloat())
}

// endregion